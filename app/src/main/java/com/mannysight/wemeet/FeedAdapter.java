package com.mannysight.wemeet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Emmanuel on 1/22/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_POST = 1;
    private final int VIEW_TYPE_SHARED_POST = 2;


    private LayoutInflater inflater;
    private MainActivity activity;

    private ArrayList<Post> posts;

    public FeedAdapter(MainActivity activity) {
        this.activity = activity;
        inflater = activity.getLayoutInflater();
        posts = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {

        if (posts.get(position).isShared()) {
            return VIEW_TYPE_SHARED_POST;
        } else {
            return VIEW_TYPE_POST;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_POST:
                View postView = inflater.inflate(R.layout.list_item_post, parent, false);
                PostViewHolder postHolder = new PostViewHolder(postView);
                return postHolder;
            case VIEW_TYPE_SHARED_POST:
                View sharedView = inflater.inflate(R.layout.list_item_shared_post, parent, false);
                SharedPostViewHolder sharedHolder = new SharedPostViewHolder(sharedView);
                return sharedHolder;
        }
        throw new IllegalArgumentException("View type " + viewType + " is not supported");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_POST:
                PostViewHolder postViewHolder = (PostViewHolder) holder;
                Post post = posts.get(position);
                postViewHolder.populate(activity, post);
                break;
            case VIEW_TYPE_SHARED_POST:
                SharedPostViewHolder sPostViewHolder = (SharedPostViewHolder) holder;
                Post sharedPost = posts.get(position);
                sPostViewHolder.populate(activity, sharedPost);
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

}
