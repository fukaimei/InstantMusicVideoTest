package com.example.instantmusicvideotest.entity;

import java.io.Serializable;

/**
 * 短视频信息表
 */
public class ShortVideoInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    // 视频播放Url
    private String videoUrl;
    // 文本内容
    private String textContent;
    // 视频封面
    private String videoCover;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getVideoCover() {
        return videoCover;
    }

    public void setVideoCover(String videoCover) {
        this.videoCover = videoCover;
    }

}
