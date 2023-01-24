package com.example.picturematch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
public class NoTimeLimit_Activity extends AppCompatActivity {

    String level[]={"Level-1","Level-2","Level-3","Level-4","Level-5","Level-6","Level-7","Level-8","Level-9"};
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_time_limit);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerAdapter=new RecyclerAdapter(NoTimeLimit_Activity.this,level);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

    }
}