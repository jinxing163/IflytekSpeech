package com.iflytek.service;

import java.util.concurrent.ExecutionException;

/**
 * 文字转语音服务
 * @author JinXing
 * @date 2020/6/18 19:27
 */
public interface BaseSpeechService {


    /**
     * 文字转语音
     * @param text 要转换的文本
     */
    void textToSpeech(String text) throws InterruptedException, ExecutionException;


}
