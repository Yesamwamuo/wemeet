package com.mannysight.wemeet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Emmanuel on 1/22/2017.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.author)
    TextView authorText;

    @BindView(R.id.created_at)
    TextView createdAtText;

    @BindView(R.id.post_text)
    TextView postText;

    @BindView(R.id.quantity)
    TextView quantityText;

    @BindView(R.id.likes)
    TextView likes;

    @BindView(R.id.messages)
    TextView messages;

    @BindView(R.id.shares)
    TextView shares;

    @BindView(R.id.post_image)
    ImageView postImage;

    @BindView(R.id.post_type)
    TextView postType;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(Context context, Post post) {
        authorText.setText(post.getAuthor());
        createdAtText.setText(post.getCreatedAt());
        postText.setText(post.getPostText());
        quantityText.setText(String.valueOf(post.getQuantity()));
        likes.setText(String.valueOf(post.getLikes()));
        messages.setText(String.valueOf(post.getMessages()));
        shares.setText(String.valueOf(post.getShares()));
        postImage.setImageResource(post.getAuthorPictureUrl());
        postType.setText("posted");
    }
}
