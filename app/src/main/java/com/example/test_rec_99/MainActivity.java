package com.example.test_rec_99;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter adapter;
    ArrayList<MainModel> models;
    private MainAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callMainList();
    }

    public void callMainList() {


        setOnClickListener();


        recyclerView = findViewById(R.id.rc_main);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        ArrayList<MainModel> mainModels = new ArrayList<>();
        mainModels.add(new MainModel(R.drawable.avatar1, "Lê Thị Như Phương", "Super ultra fantastic gud"));
        mainModels.add(new MainModel(R.drawable.avatar_2, "Nguyễn Minh Khoa", "Super ultra fantastic perfect"));
        mainModels.add(new MainModel(R.drawable.avatar_3, "Nguyễn Văn A", "Super ultra fantastic beautiful Super ultra fantastic beautiful"));
        mainModels.add(new MainModel(R.drawable.avatar_4, "Lê Thị B", "Super ultra fantastic beautiful ultra ultra ultra ultra"));
        MainAdapter mainAdapter = new MainAdapter(mainModels, getApplicationContext(), listener);
        recyclerView.setAdapter(mainAdapter);


    }

    //////////////////////////
    private void setOnClickListener() {
        listener = new MainAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {

                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);

                intent.putExtra("Title", models.get(position).getTitle());

                startActivity(intent);

            }
        };
    }
}