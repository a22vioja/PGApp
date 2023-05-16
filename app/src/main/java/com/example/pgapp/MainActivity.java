package com.example.pgapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonExplore= findViewById(R.id.buttonExplore);
        buttonExplore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // makes the button in MainActivity page open About page screen
                Intent intent = new Intent(MainActivity.this, AboutPage.class);
                startActivity(intent);

            }
        });
    }
}