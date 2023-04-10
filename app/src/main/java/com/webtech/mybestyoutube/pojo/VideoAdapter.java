package com.webtech.mybestyoutube.pojo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webtech.mybestyoutube.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.YoutubeVideoViewHolder> {
    private final List<Video> youtubeVideoList;
    private final OnItemClickListener listener;

    public class YoutubeVideoViewHolder extends RecyclerView.ViewHolder {
        public TextView Title;
        public TextView Category;
        public TextView Creator;

        public YoutubeVideoViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            Creator = itemView.findViewById(R.id.creator);
        }

        public void bind(final Video item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public VideoAdapter(List<Video> youtubeVideoList, OnItemClickListener listener) {
        this.youtubeVideoList = youtubeVideoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public YoutubeVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.youtube_video_item, parent, false);
        return new YoutubeVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(YoutubeVideoViewHolder holder, int position) {
        Video youtubeVideo = youtubeVideoList.get(position);
        holder.Title.setText(youtubeVideo.getTitle());
        holder.Creator.setText(youtubeVideo.getCreator());
        holder.bind(youtubeVideo, listener);
    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Video item);
    }
}
