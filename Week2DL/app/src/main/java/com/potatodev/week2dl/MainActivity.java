package com.potatodev.week2dl;

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

        for (int i=0; i<69; i++){
            dummyLists.add("Dummy Item " + (i+1));
        }

        fabAdd = findViewById(R.id.fabAdd);
        rvList = findViewById(R.id.rvList);

        adapter = new DummyAdapter(this, dummyLists);

        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = "Dummy Item " + String.valueOf(dummyLists.size() + 1);
                dummyLists.add(item);
                adapter.notifyDataSetChanged();
                rvList.smoothScrollToPosition(dummyLists.size());
                Toast.makeText(v.getContext(), item + " Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}