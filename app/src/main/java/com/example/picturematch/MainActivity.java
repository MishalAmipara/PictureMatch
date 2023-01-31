package com.example.picturematch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView noLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.txtNoLimit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NoTimeLimit_Activity.class);
                intent.putExtra("lable","noLimit");
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.txtNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NoTimeLimit_Activity.class);
                intent.putExtra("lable","normal");
                startActivity(intent);
                finish();
            }
        });
    }
}