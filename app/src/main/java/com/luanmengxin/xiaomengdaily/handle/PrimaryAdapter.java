package com.luanmengxin.xiaomengdaily.handle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.luanmengxin.xiaomengdaily.R;
import com.luanmengxin.xiaomengdaily.SpecificMessage;
import com.luanmengxin.xiaomengdaily.entity.Story;

import java.util.List;

/**
 * Created by 我爱王金ge on 2019/11/7.
 */

public class PrimaryAdapter extends RecyclerView.Adapter<PrimaryAdapter.ViewHolder>{

    private static final String TAG = "PrimaryAdapter";
    private List<Story> mStories;
    private static Context mContext;
//    private String id;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View storyView;
        TextView titleText;
        TextView hintText;

        public ViewHolder(View itemView) {
            super(itemView);
            storyView = itemView;
            titleText = (TextView)itemView.findViewById(R.id.name);
            hintText = (TextView)itemView.findViewById(R.id.hint);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.primary_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.storyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Story story = mStories.get(position);
//                id = story.getId();
                Toast.makeText(v.getContext(),story.getTitle(),Toast.LENGTH_SHORT).show();
                if(mContext != null){
                    Intent intent = new Intent(mContext, SpecificMessage.class);
                    Log.d(TAG, "我是测试的id:" + story.getId());
                    intent.putExtra("id",story.getId());
                    mContext.startActivity(intent);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Story story = mStories.get(position);
        holder.hintText.setText(story.getHint());
        holder.titleText.setText(story.getTitle());
    }

    @Override
    public int getItemCount() {
        return mStories.size();
    }

    public PrimaryAdapter(List<Story> stories){
        mStories = stories;
    }

    public void setContext(Context context) {
        PrimaryAdapter.mContext = context;
    }

    //    public String getId(){
//        return this.id;
//    }
}
