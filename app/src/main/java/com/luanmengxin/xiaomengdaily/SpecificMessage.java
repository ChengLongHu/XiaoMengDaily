package com.luanmengxin.xiaomengdaily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.luanmengxin.xiaomengdaily.json.DetailStory;
import com.luanmengxin.xiaomengdaily.util.HttpUtil;
import com.luanmengxin.xiaomengdaily.util.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SpecificMessage extends AppCompatActivity {

    private static final String TAG = "SpecificMessage";
    private String id;
    private TextView messageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_message);
        messageText = (TextView)findViewById(R.id.messages);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.d(TAG, "onCreate: " + id + "_______________________");
        //http://news-at.zhihu.com/api/4/news/{id}
        showMessages();
    }

    private void showMessages(){
        final String storyUrl = "http://news-at.zhihu.com/api/4/news/" + id;
        HttpUtil.sendOkHttpRequest(storyUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(SpecificMessage.this,"数据获取失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.d("SpecificMessage",responseText+"-------------------");
                final DetailStory detailStory = Utility.handleDetailStoryResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        messageText.setText(detailStory.body);
                    }
                });

            }
        });
    }

}
