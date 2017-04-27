package com.gabrielaangebrandt.bugsy;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    ArrayList<Objekt> news;
    RecyclerView recyclerView;
    NewsAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();

    }

    private void setUpUI() {
        Context context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        Read readRss = new Read(this);
        readRss.execute();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);



    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {

            @Override public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 5000);

    }
}


