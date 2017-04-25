package com.gabrielaangebrandt.bugsy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();
    }

    private void setUpUI() {
        Context context = getApplicationContext();
        this.recyclerView = (RecyclerView) findViewById(R.id.rv);
        this.newsAdapter = new NewsAdapter(this.loadNews());
        this.layoutManager = new LinearLayoutManager(context);

        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(newsAdapter);
    }

    private ArrayList<Objekt> loadNews(){
        ArrayList<Objekt> news = new ArrayList<>();
        return news;

    }
}
