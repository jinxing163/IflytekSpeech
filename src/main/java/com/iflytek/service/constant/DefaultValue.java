package com.iflytek.service.constant;

import com.iflytek.cloud.speech.SpeechConstant;

/**
 * @author JinXing
 * @date 2020/6/18 17:26
 */
public class DefaultValue {

    /**
     * 音频的采样率是音频属性的其中一个，一般来说，采样率越高音频的质量越好，识别的匹配率越高，但上传带宽消耗也越大。 默认：16KHZ，取值{8KHZ,16KHZ}
     */
    public static final String RATE = "16000";
    public static final String ENG_TYPE = SpeechConstant.TYPE_CLOUD;
    public static final String VOICE = "x2_yifei";
    public static final String BACKGROUND_SOUND = "0";
    public static final String SPEED = "35";
    public static final String PITCH = "50";
    public static final String VOLUME = "60";
    public static final String SAVE = "0";




}

