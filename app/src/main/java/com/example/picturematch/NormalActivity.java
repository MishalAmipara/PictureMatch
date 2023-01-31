package com.example.picturematch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends AppCompatActivity {

    LevelAdapter levelAdapter;
    RecyclerView recyclerView;
    List<String> arrayList;
    int position;
    int numOfImage=6;
    ArrayList<String> listImages;
    int column=3,row=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);


    }
}