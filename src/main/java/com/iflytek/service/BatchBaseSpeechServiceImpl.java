package com.iflytek.service;

import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;
import com.iflytek.service.constant.DefaultValue;
import com.iflytek.util.ConvertUtils;
import com.iflytek.util.SplitUtil;
import com.iflytek.util.Version;
import com.iflytek.view.TtsSpeechView;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 讯飞语音功能
 * SDK&API 错误码查询：https://www.xfyun.cn/document/error-code
 *
 * ## 遇到的问题1：onCompleted Code：11200
 *
 * 原因：服务没有授权
 * 1. 总调用量超过上限。
 * 2. 功能未授权或授权已过期。
 * 听写：使用了未授权的听写语种、方言、垂直领域参数等会报此错误。
 * 合成：使用了未授权的发音人参数。
 * 评测：使用了未授权的高阶功能(篇章、全维度等)。
 *
 * @author JinXing
 * @date 2020/6/18 19:40
 */

@Service
public class BatchBaseSpeechServiceImpl implements BaseSpeechService {

    @Override
    public void textToSpeech(String text) throws InterruptedException, ExecutionException {



        //文件路径《替换成你的》
        String filePath = "E:\\0.testPck\\xunFei\\file\\";

        long start = System.currentTimeMillis();
        int totalLen = text.length();
        AtomicInteger realLen = new AtomicInteger();

        //批处理
        List<Callable<String>> tasks = new ArrayList<>();
        SplitUtil.splitByPageSize(1, totalLen, 500, (from1, to1, pageNum1) -> {
            System.out.println(Thread.currentThread() + "当前页码:" + pageNum1 + " " + from1 + " -> " + to1);

            String currentText = text.substring(from1 - 1, to1);
            int cLen = currentText.length();
            realLen.addAndGet(cLen);
            System.out.println("当前截取后的文字长度：" + cLen);

            String fileName = filePath + System.currentTimeMillis() + "_task" + pageNum1 + "_";
//            toTask(fileName, currentText, synthesizer);

            //创建任务执行器
            Callable<String> qfe = new MultiThreading("textToSpeech",fileName, currentText);
            tasks.add(qfe);

        });


        //定义固定长度的线程池  防止线程过多
        List<String> finalList = new ArrayList<>(totalLen);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = executorService.invokeAll(tasks);
        // 处理线程返回结果
        if (futures.size() > 0) {
            for (Future<String> future : futures) {
                finalList.add(future.get());
            }
        }
        //关闭线程池
        executorService.shutdown();
        long end = System.currentTimeMillis();
        println("查询总数据量-------------" + totalLen);
        println("实际查询总数据量-------------" + realLen.get());
        println("查询数据用时----------------" + (start - end)/1000 + "s");
        println("finalList::::"+finalList);


    }


    public class MultiThreading implements Callable<String> {


        /** 接口服务调用条件 */
        String fileName;
        String text;
        SpeechSynthesizer synthesizer;

        private String methodName;

        MultiThreading(String methodName, String fileName, String text) {
            this.fileName = fileName;
            this.text = text;
            this.methodName = methodName;
        }

        @Override
        public String call() {

            //通过service查询得到对应结果
            try {

                println("执行方法：" + methodName);
                return toTask(fileName, text);

            } catch (Exception e) {
                e.printStackTrace();
                println("执行异常 e=" + e);
            }

            return "无返回结果";
        }
    }



    private String toTask(String fileName, String text) {

        //初始化
//        initSpeechUtility();

        SpeechUtility.createUtility(SpeechConstant.APPID + "=" + Version.getAppId());

        //创建实例
//        SpeechSynthesizer synthesizer = getSpeechSynthesizer();

        SpeechSynthesizer synthesizer = SpeechSynthesizer.createSynthesizer();

        //文件命名-需要先转pcm格式
        String pcmFileSrc = fileName + "tts_test.pcm";
        //文件命名-后将pcm格式转为mp3格式
        String mp3FileSrc = fileName + "tts_test.mp3";

        //参数设置
        setParameter(synthesizer, pcmFileSrc);

        SynthesizerListener mSynListener = new TtsSpeechView().mSynListener;
        synthesizer.startSpeaking(text, mSynListener);

        //判断是否合成完毕
        isSpeaking(synthesizer, pcmFileSrc, mp3FileSrc);

        return mp3FileSrc;
    }

    /**
     * 判断是否合成完毕，完毕后需要将pcm格式转为mp3格式
     */
    private void isSpeaking(SpeechSynthesizer synthesizer, String pcmFileSrc, String mp3FileSrc) {

        while (true) {

            //是否在合成 false：否；true：是。
            boolean speaking = synthesizer.isSpeaking();
            println("当前合成状态：", (speaking ? "正在合成" : "不再合成"));

            try {

                //防止遍历太过频繁
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!speaking) {

                //将pcm格式转为mp3格式
                println("合成完毕..........break");
                convertPcm2Wav(pcmFileSrc, mp3FileSrc);
                break;
            }

        }
    }

    /**
     * 创建实例
     */
    private SpeechSynthesizer getSpeechSynthesizer() {
        SpeechSynthesizer synthesizer = SpeechSynthesizer.getSynthesizer();
        if (synthesizer == null) {
            synthesizer = SpeechSynthesizer.createSynthesizer();
        }
        return synthesizer;
    }

    /**
     * 初始化
     */
    private void initSpeechUtility() {

        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility == null) {
            //初始化sdk
            SpeechUtility.createUtility(SpeechConstant.APPID + "=" + Version.getAppId());
        }

    }

    /**
     * 参数设置
     * SpeechConstant.VOICE_NAME: 发音人
     * SpeechConstant.SPEED: 合成语速
     * SpeechConstant.VOLUME: 合成音量
     * SpeechConstant.PITCH: 合成语调
     * SpeechConstant.BACKGROUND_SOUND: 背景音乐
     * SpeechConstant.TTS_BUFFER_TIME: 合成音频缓冲时间
     * SpeechConstant.STREAM_TYPE: 播放类型
     * SpeechConstant.TTS_AUDIO_PATH: 合成录音保存路径
     */
    private static void setParameter(SpeechSynthesizer synthesizer, String pcmFileSrc) {

        synthesizer.setParameter(SpeechConstant.VOICE_NAME, DefaultValue.VOICE);
        synthesizer.setParameter(SpeechConstant.SPEED, DefaultValue.SPEED);
        synthesizer.setParameter(SpeechConstant.VOLUME, DefaultValue.VOLUME);
        synthesizer.setParameter(SpeechConstant.PITCH, DefaultValue.PITCH);
        synthesizer.setParameter(SpeechConstant.BACKGROUND_SOUND, DefaultValue.BACKGROUND_SOUND);
        synthesizer.setParameter(SpeechConstant.STREAM_TYPE, DefaultValue.ENG_TYPE);
        synthesizer.setParameter(SpeechConstant.SAMPLE_RATE, DefaultValue.RATE);
        synthesizer.setParameter(SpeechConstant.TTS_AUDIO_PATH, pcmFileSrc);

    }


    /**
     * 将pcm格式转为mp3格式
     */
    private static void convertPcm2Wav(String pcmFileSrc, String mp3FileSrc) {

        if (StringUtils.isEmpty(pcmFileSrc) || StringUtils.isEmpty(mp3FileSrc)) {
            println("pcmFileSrc、mp3FileSrc 为空");
            return;
        }

        println("转换前的音频地址", pcmFileSrc);

        try {

            ConvertUtils.convertPcm2Wav(pcmFileSrc, mp3FileSrc);
            println("转换后的音频地址", mp3FileSrc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void println(String pcmFileSrc, Object... arguments) {

        StringBuilder stringBuilder = new StringBuilder(" ");
        for (Object param : arguments) {
            stringBuilder.append(param);
        }

        System.out.println(pcmFileSrc + stringBuilder.toString());
    }

    public static void main(String[] args) {

        String text = "AAAAAAAAAABBBBBBBBBBCC";
        int len = text.length();
        System.out.println(len);
        AtomicInteger add = new AtomicInteger();
        SplitUtil.splitByPageSize(1, len, 10, (from1, to1, pageNum1) -> {
            System.out.println(Thread.currentThread() + "当前页码:" + pageNum1 + " " + from1 + " -> " + to1);
            String substring = text.substring(from1 - 1, to1);
            int length = substring.length();
            add.addAndGet(length);
            System.out.println("当前长度：" + length);
            System.out.println(substring);

        });
        System.out.println(add);

    }


}
