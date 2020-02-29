package com.example.mvvmarchitecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView
        RecyclerView postList = findViewById(R.id.post_list);
        final PostListAdapter listAdapter = new PostListAdapter(this);
        postList.setAdapter(listAdapter);
        postList.setLayoutManager(new LinearLayoutManager(this));
    }
}
