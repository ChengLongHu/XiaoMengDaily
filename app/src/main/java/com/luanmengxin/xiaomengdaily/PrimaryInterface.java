package com.luanmengxin.xiaomengdaily;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.luanmengxin.xiaomengdaily.entity.Story;
import com.luanmengxin.xiaomengdaily.handle.PrimaryAdapter;
import com.luanmengxin.xiaomengdaily.json.Stories;
import com.luanmengxin.xiaomengdaily.util.HttpUtil;
import com.luanmengxin.xiaomengdaily.util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PrimaryInterface extends AppCompatActivity {

//    private TextView titleText;
//    private TextView hintText;
//    private ImageView imageView;
//    Story story;
    Context context = this;
    String title;
    String hint;
    String imageUrl;

    RecyclerView recyclerView;
    private List<Story> storyList = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
//                    if(title != null) {
////                        hintText.setText(hint);
////                        titleText.setText(title);
////                        byte[] bitmapArray = Base64.decode(imageUrl, Base64.DEFAULT);
////                        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length));
////                        imageView.setImageResource(R.mipmap.timg);
//                    }
//                    else{
//                        titleText.setText("失败！");
//                    }
                    PrimaryAdapter adapter = new PrimaryAdapter(storyList);
                    recyclerView.setAdapter(adapter);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_interface);

//        imageView = (ImageView)findViewById(R.id.title_image);
//        TextPaint paint = titleText.getPaint();
//        paint.setFakeBoldText(true);
//        showTitle();
        initStory();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }

    private void initStory(){
        final String storyUrl = "http://news-at.zhihu.com/api/4/news/latest";
        HttpUtil.sendOkHttpRequest(storyUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(PrimaryInterface.this,"数据获取失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final Stories mStroies = Utility.handleStoriesResponse(responseText);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        for(Stories.mStories mStory : mStroies.stories){
//                            title = mStory.title;
//                            hint = mStory.hint;
//                            imageUrl = mStory.images;
//                            Log.d("PrimaryInterface", title);
//                            Story story = new Story(title,hint,imageUrl);
//                            storyList.add(story);
//                        }
//                        Message msg = new Message();
//                        msg.what = 1;
//                        handler.sendMessage(msg);
//                    }
//                }).start();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(Stories.mStories mStory : mStroies.stories){
                            title = mStory.title;
                            hint = mStory.hint;
                            imageUrl = mStory.images;
                            Log.d("PrimaryInterface", title);
                            Story story = new Story(title,hint,imageUrl);
                            story.setId(mStory.id);
                            storyList.add(story);
                        }
                        PrimaryAdapter adapter = new PrimaryAdapter(storyList);
                        adapter.setContext(context);
                        recyclerView.setAdapter(adapter);
                    }
                });

            }
        });
    }

}
