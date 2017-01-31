package com.mannysight.wemeet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Emmanuel on 1/22/2017.
 */

public class FeedFragment extends Fragment {

    private ArrayList<Post> posts;
    private FeedAdapter feedAdapter;

    @BindView(R.id.fragment_feed_recyclerView)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        ButterKnife.bind(this, rootView);
        feedAdapter = new FeedAdapter((MainActivity) getActivity());
        posts = feedAdapter.getPosts();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setUpAdapter();
        getData();

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "FAB Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void getData() {
        int oldSize = posts.size();
        if (oldSize == 0) {
            posts.clear();
            feedAdapter.notifyItemRangeRemoved(0, oldSize);
            posts.addAll(Post.getPosts());
            feedAdapter.notifyItemRangeChanged(0, posts.size());
        }
    }

    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(feedAdapter);
        }
    }


    public static FeedFragment newInstance() {
        return new FeedFragment();
    }
}
