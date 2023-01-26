package com.example.picturematch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Level_Activity extends AppCompatActivity {

    int[] imgArr={R.drawable.aguacate,R.drawable.ajo,R.drawable.ardilla,R.drawable.bellota,R.drawable.barco,R.drawable.bombon,
            R.drawable.aguacate,R.drawable.ajo,R.drawable.ardilla,R.drawable.bellota,R.drawable.barco,R.drawable.bombon};
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
        setContentView(R.layout.activity_level);
        recyclerView=findViewById(R.id.recyclerView_level);
        position=getIntent().getIntExtra("level",0);
        if(position<2)
        {
            numOfImage=6;
            column=3;
        }
        else if (position>1&&position<5)
        {
            numOfImage=8;
            column=4;
        }
        else if(position>5)
        {
            numOfImage=10;
            column=5;
            row=5;
        }
        String[] images = new String[0];
        try {
            images = getAssets().list("");
            listImages= new ArrayList<String>(Arrays.asList(images));
        } catch (IOException e) {
            e.printStackTrace();
        }

        arrayList=listImages.subList(0,numOfImage);
        arrayList.addAll(arrayList);



//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            arrayList= Arrays.stream(imgArr).boxed().collect(Collectors.toList());
//        }
        Collections.shuffle(arrayList);
        levelAdapter=new LevelAdapter(Level_Activity.this,arrayList);
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,column);
        //gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        //linearLayoutManager.setOrientation(LinearLayoutManager.);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(levelAdapter);
    }
}