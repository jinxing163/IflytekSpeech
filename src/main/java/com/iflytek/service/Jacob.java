package com.iflytek.service;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

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
public class Jacob implements BaseSpeechService {


    /**
     * 语音转文字并播放
     *
     * @param text
     */
    @Override
    public void textToSpeech(String text) throws InterruptedException, ExecutionException{
        ActiveXComponent ax = null;
        try {
            ax = new ActiveXComponent("Sapi.SpVoice");

            // 运行时输出语音内容
            Dispatch spVoice = ax.getObject();
            // 音量 0-100
            ax.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            ax.setProperty("Rate", new Variant(-2));
            // 执行朗读
            Dispatch.call(spVoice, "Speak", new Variant(text));

            // 下面是构建文件流把生成语音文件

            ax = new ActiveXComponent("Sapi.SpFileStream");
            Dispatch spFileStream = ax.getObject();

            ax = new ActiveXComponent("Sapi.SpAudioFormat");
            Dispatch spAudioFormat = ax.getObject();

            // 设置音频流格式
            Dispatch.put(spAudioFormat, "Type", new Variant(22));
            // 设置文件输出流格式
            Dispatch.putRef(spFileStream, "Format", spAudioFormat);
            // 调用输出 文件流打开方法，创建一个.wav文件
            Dispatch.call(spFileStream, "Open", new Variant("./text.mp3"), new Variant(3), new Variant(true));
            // 设置声音对象的音频输出流为输出文件对象
            Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
            // 设置音量 0到100
            Dispatch.put(spVoice, "Volume", new Variant(100));
            // 设置朗读速度
            Dispatch.put(spVoice, "Rate", new Variant(-2));
            // 开始朗读
            Dispatch.call(spVoice, "Speak", new Variant(text));

            // 关闭输出文件
            Dispatch.call(spFileStream, "Close");
            Dispatch.putRef(spVoice, "AudioOutputStream", null);

            spAudioFormat.safeRelease();
            spFileStream.safeRelease();
            spVoice.safeRelease();
            ax.safeRelease();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String s = "当月亮和太阳处于地球两侧，并且月亮和太阳的黄经相差180度时，从地球上看，此时的月亮最圆，称之为“满月”";
        new Jacob().textToSpeech(s);
        File file = new File("E:\\0.testPck\\xunFei\\file\\result.mp3"); // 打开mp3文件即可播放
        String fileName = "Operator.doc".toString(); // 文件的默认保存名
        // 读到流中
        try {
            InputStream inStream = new FileInputStream("c:/Operator.doc");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 文件的存放路径
    }


}
