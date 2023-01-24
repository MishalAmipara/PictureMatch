package com.example.picturematch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

public class Level_Activity extends AppCompatActivity {

    int[] imgArr={R.drawable.aguacate,R.drawable.ajo,R.drawable.ardilla,R.drawable.bellota,R.drawable.barco,R.drawable.bombon,
            R.drawable.aguacate,R.drawable.ajo,R.drawable.ardilla,R.drawable.bellota,R.drawable.barco,R.drawable.bombon};
    LevelAdapter levelAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


    }
}