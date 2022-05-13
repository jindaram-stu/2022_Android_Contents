package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MusicPlayerActivity extends AppCompatActivity{

    Button start, stop;
    MusicPlayerActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        start = findViewById(R.id.startMusic);
        stop = findViewById(R.id.stopMusic);
        start.setOnClickListener(click);
        stop.setOnClickListener(click);
        activity = this;
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.startMusic :
                    System.out.println("dd");
                    Log.d("[MusicPlayerActivity]","startButtonClicked");
                    startService(new Intent(activity,MusicService.class));
                    break;
                case R.id.stopMusic :
                    Log.d("[MusicPlayerActivity]","stopButtonClicked");
                    stopService(new Intent(activity,MusicService.class));
                    break;
            }
        }
    };

}