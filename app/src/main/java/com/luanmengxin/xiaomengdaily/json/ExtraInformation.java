package com.luanmengxin.xiaomengdaily.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 我爱王金ge on 2019/11/7.
 */

public class ExtraInformation {
    @SerializedName("long_comments")
    public String long_comments;
    @SerializedName("popularity")
    public String popularity;
    @SerializedName("short_comments")
    public String short_comments;
    @SerializedName("comments")
    public String comments;
}
