package com.gabrielaangebrandt.bugsy;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, Callback<RSSFeed>, AdapterView.OnItemSelectedListener {

    RecyclerView recyclerView;
    NewsAdapter adapter;
    private static final String page = "http://www.bug.hr/";
    SwipeRefreshLayout swipeRefreshLayout;
    LinearLayoutManager layoutManager;
    List<Objekt> all, objects;

    Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();

    }

    private void setUpUI() {
        Context context = getApplicationContext();

        this.recyclerView = (RecyclerView) findViewById(R.id.rv);

        this.layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new NewsAdapter(this.newsList());

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter_spinner = ArrayAdapter.createFromResource(this,
                R.array.category, android.R.layout.simple_spinner_item);
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter_spinner);
        spinner1.setOnItemSelectedListener(this);


    }

    private ArrayList<Objekt> newsList() {

        ArrayList<Objekt> news = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(page)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<RSSFeed> call = api.loadRSSFeed();
        call.enqueue(this);
        return news;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {

            @Override public void run() {
                swipeRefreshLayout.setRefreshing(false);

            }
        }, 2000);
        newsList();

    }


    @Override
    public void onResponse(Call<RSSFeed> call, Response<RSSFeed> response) {

        List<Objekt> news = response.body().getList();
        NewsAdapter adapter = new NewsAdapter((ArrayList<Objekt>) news);
        this.recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFailure(Call<RSSFeed> call, Throwable t) {
        Log.d("fail", t.getMessage());

    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = this.spinner1.getSelectedItem().toString();
        this.all = new ArrayList<>();
        this.objects = new ArrayList<>();
        for (Objekt objekt : all) {
            if (objekt.getMcategory()== item) {
                objects.add(objekt);
            }
        } adapter.notifyDataSetChanged();
    }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }
    }




