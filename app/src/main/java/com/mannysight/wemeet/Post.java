package com.mannysight.wemeet;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Emmanuel on 1/22/2017.
 */

public class Post {


    private String author;
    private int authorPictureUrl;
    private String postText;
    private String likes;
    private int messages;
    private int shares;
    private int quantity;
    private boolean isShared;
    private String createdAt;

    public Post(String author, String postText, String likes, int messages, int shares, int quantity, boolean isShared, String createdAt, int authorPictureUrl) {
        this.author = author;
        this.postText = postText;
        this.likes = likes;
        this.messages = messages;
        this.shares = shares;
        this.quantity = quantity;
        this.isShared = isShared;
        this.createdAt = createdAt;
        this.authorPictureUrl = authorPictureUrl;
    }

    public String getAuthor() {
        return author;
    }

    public String getPostText() {
        return postText;
    }

    public String getLikes() {
        return likes;
    }

    public int getMessages() {
        return messages;
    }

    public int getShares() {
        return shares;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isShared() {
        return isShared;
    }

    public static ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        Post post1 = new Post(
                "Shixels Studios LTD",
                "Nice looking brand new Mercedes Benz",
                "2K",
                98,
                69,
                99,
                false,
                "2h",
                R.drawable.mercerdes
        );
        posts.add(post1);
        Post post2 = new Post(
                "Lekki Housewives",
                "Sleek pair of Adidas Sneakers",
                "1K",
                23,
                13,
                45,
                true,
                "3h",
                R.drawable.adidas
        );
        posts.add(post2);

        return posts;
    }

    public int getAuthorPictureUrl() {
        return authorPictureUrl;
    }
}
