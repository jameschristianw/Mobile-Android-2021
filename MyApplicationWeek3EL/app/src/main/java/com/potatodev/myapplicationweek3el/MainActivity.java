package com.potatodev.myapplicationweek3el;

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

    List<String> dummyText = new ArrayList<>();

    DummyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<30; i++){
            dummyText.add("Dummy Text " + String.valueOf(i+1));
        }

        fabAdd = findViewById(R.id.fabAdd);
        rvList = findViewById(R.id.rvList);

        adapter = new DummyListAdapter(this, dummyText);
        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dummyText.add("Dummy Text " + String.valueOf(dummyText.size() + 1));
                adapter.notifyDataSetChanged();
                rvList.smoothScrollToPosition(dummyText.size());
                Log.d("MainActivity", String.valueOf(dummyText.size()));
                Toast.makeText(v.getContext(), "Data added to List", Toast.LENGTH_SHORT).show();
            }
        });
    }
}