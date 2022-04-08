package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

//    Animation cat_anim;
//    ImageView cat_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // cat_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_splash_imageview);
        // cat_image.findViewById(R.id.cat);

    }

    // about Android Handler : https://junghun0.github.io/2019/06/11/android-handler/
    @Override
    protected void onStart() {
        super.onStart(); // 서브 스레드를 통해 해당 run() 메소드를 onStart() 메소드 시작 2000m/s 이후에 실행한다.


//         cat_image.startAnimation(cat_anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,InitActivity.class);
                startActivity(intent);
            }
        },2000);
    }
}