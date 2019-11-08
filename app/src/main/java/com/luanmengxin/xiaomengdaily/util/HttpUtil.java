package com.luanmengxin.xiaomengdaily.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 我爱王金ge on 2019/11/7.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
