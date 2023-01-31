package com.example.picturematch;

import static com.example.picturematch.config.seekBar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Level_Activity extends AppCompatActivity {

    int[] imgArr={R.drawable.aguacate,R.drawable.ajo,R.drawable.ardilla,R.drawable.bellota,R.drawable.barco,R.drawable.bombon,
            R.drawable.aguacate,R.drawable.ajo,R.drawable.ardilla,R.drawable.bellota,R.drawable.barco,R.drawable.bombon};
    LevelAdapter levelAdapter;
    RecyclerView recyclerView;
    List<String> arrayList;
    int position;
    int numOfImage=6;
    //public static int t=0;
    ArrayList<String> listImages;
    int column=3,row=3;
    //public static SeekBar seekBar;
    View view;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        recyclerView = findViewById(R.id.recyclerView_level);
        seekBar=findViewById(R.id.seekbar);
        if (config.outerLevel == 1)
        {
            seekBar.setVisibility(View.GONE);
            position = getIntent().getIntExtra("level", 0);
            if (position < 2) {
                numOfImage = 6;
                column = 3;
            } else if (position > 1 && position < 5) {
                numOfImage = 8;
                column = 4;
            } else if (position > 5) {
                numOfImage = 10;
                column = 5;
                row = 5;
            }
            String[] images = new String[0];
            try {
                images = getAssets().list("");
                listImages = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                e.printStackTrace();
            }
            arrayList = listImages.subList(0, numOfImage);
            arrayList.addAll(arrayList);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            arrayList= Arrays.stream(imgArr).boxed().collect(Collectors.toList());
//        }
            Collections.shuffle(arrayList);
            levelAdapter = new LevelAdapter(Level_Activity.this, arrayList);
            //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, column);
            //gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            //linearLayoutManager.setOrientation(LinearLayoutManager.);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(levelAdapter);
        }
        else if(config.outerLevel==2)
        {
            seekBar.setMax(120);
            seekBar.setVisibility(View.VISIBLE);
            Timer timer=new Timer();
          timer.schedule(new TimerTask() {
                @Override
                public void run()
                {
                    config.t++;
                 seekBar.setProgress(config.t);
                }
            }, 10000, 100);

            if(seekBar.getProgress()==120)
            {
                relativeLayout.setClickable(false);
                System.out.println("Relative Clicked");
            }
            position = getIntent().getIntExtra("level", 0);
            if (position < 2) {
                numOfImage = 6;
                column = 3;
            } else if (position > 1 && position < 5) {
                numOfImage = 8;
                column = 4;
            } else if (position > 5) {
                numOfImage = 10;
                column = 5;
                row = 5;
            }
            String[] images = new String[0];
            try {
                images = getAssets().list("");
                listImages = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                e.printStackTrace();
            }
            arrayList = listImages.subList(0, numOfImage);
            arrayList.addAll(arrayList);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            arrayList= Arrays.stream(imgArr).boxed().collect(Collectors.toList());
//        }
            Collections.shuffle(arrayList);
            levelAdapter = new LevelAdapter(Level_Activity.this, arrayList);
            //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, column);
            //gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            //linearLayoutManager.setOrientation(LinearLayoutManager.);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(levelAdapter);
        }
    }
}