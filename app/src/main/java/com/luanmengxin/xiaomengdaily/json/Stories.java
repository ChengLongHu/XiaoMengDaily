package com.luanmengxin.xiaomengdaily.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 我爱王金ge on 2019/11/7.
 */

public class Stories {
    @SerializedName("date")
    String date;
    @SerializedName("stories")
    public List<mStories> stories;
    @SerializedName("top_stories")
    public List<mStories> top_stories;

    public class mStories{
        @SerializedName("title")
        public String title;
        @SerializedName("hint")
        public String hint;
        @SerializedName("image")
        public String images;
        @SerializedName("id")
        public String id;
    }
    private class mTopStories{
        @SerializedName("title")
        public String title;
        @SerializedName("hint")
        public String hint;
        @SerializedName("image")
        public String images;
        @SerializedName("id")
        public String id;
    }

}
