package com.luanmengxin.xiaomengdaily.entity;

/**
 * Created by 我爱王金ge on 2019/11/7.
 */

public class Story {
    private String id;
    private String title;
    private String hint;
    private String imageUrl;

    public Story(String title, String hint, String imageUrl) {
        this.title = title;
        this.hint = hint;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Story(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
