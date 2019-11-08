package com.luanmengxin.xiaomengdaily.util;

import com.google.gson.Gson;
import com.luanmengxin.xiaomengdaily.json.DetailStory;
import com.luanmengxin.xiaomengdaily.json.Stories;

import org.json.JSONObject;

/**
 * Created by 我爱王金ge on 2019/11/7.
 */

public class Utility {
    public static Stories handleStoriesResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
//            JSONArray jsonArray = jsonObject.getJSONArray("stories");
            String storiesContent = jsonObject.toString();
            return new Gson().fromJson(storiesContent,Stories.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static DetailStory handleDetailStoryResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            String detailContent = jsonObject.toString();
            return new Gson().fromJson(detailContent,DetailStory.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
