package com.iflytek.service;

import com.iflytek.service.constant.DefaultValue;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;
import com.iflytek.util.ConvertUtils;
import com.iflytek.util.Version;
import com.iflytek.view.TtsSpeechView;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 讯飞语音功能
 * @author JinXing
 * @date 2020/6/18 19:40
 */

@Service
public class BaseSpeechServiceImpl implements BaseSpeechService {

    @Override
    public void textToSpeech(String text) {

        //初始化
        initSpeechUtility();

        //创建实例
        SpeechSynthesizer synthesizer = getSpeechSynthesizer();

        //文件路径《替换成你的》
        String filePath = "E:\\0.testPck\\xunFei\\file\\";
        //文件命名-需要先转pcm格式
        String pcmFileSrc = filePath + System.currentTimeMillis() + "tts_test.pcm";
        //文件命名-后将pcm格式转为mp3格式
        String mp3FileSrc = filePath + System.currentTimeMillis() + "tts_test.mp3";

        //参数设置
        setParameter(synthesizer, pcmFileSrc);

        //开始合成
        int splitLen=500;
        //由于语音合成有字数限制，所有暂时只获取500个字。后期需要将文字分批合成多个语音，再合并成一个语音。
        if(text.length() > splitLen){
            text = text.substring(0, splitLen);
        }
        System.out.println("文字个数：" + text.length());
        SynthesizerListener mSynListener = new TtsSpeechView().mSynListener;
        synthesizer.startSpeaking(text, mSynListener);

        //判断是否合成完毕
        isSpeaking(synthesizer, pcmFileSrc, mp3FileSrc);


    }

    /**
     * 判断是否合成完毕，完毕后需要将pcm格式转为mp3格式
     */
    private void isSpeaking(SpeechSynthesizer synthesizer, String pcmFileSrc, String mp3FileSrc) {

        while (true) {

            //是否在合成 false：否；true：是。
            boolean speaking = synthesizer.isSpeaking();
            System.out.println("当前合成状态：" + (speaking ? "正在合成" : "不再合成"));
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
        println("aaaa", 1, 2, 3);
    }



}
