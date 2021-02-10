package com.potatodev.week3bl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabAdd;
    RecyclerView rvList;
    DummyAdapter adapter;

    List<String> dummyLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<28; i++){
            dummyLists.add("Dummy Text " + (i + 1));
        }
        Log.d("MainActivity", dummyLists.toString());

        fabAdd = findViewById(R.id.fabAdd);
        rvList = findViewById(R.id.rvList);

        adapter = new DummyAdapter(this, dummyLists);
        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dummyLists.add("Dummy Text " + (dummyLists.size() + 1));
                adapter.notifyDataSetChanged();
                Log.d("MainActivity", dummyLists.get(dummyLists.size() - 1));
                Toast.makeText(v.getContext(), "FAB Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}