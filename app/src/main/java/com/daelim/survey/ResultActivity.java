package com.daelim.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.daelim.R;

import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {

    HashMap<String,String> resultMap;
    String bread, vegetable,cheese,sauce;
    ImageView b_one,c_one;
    ImageView[] v_list = new ImageView[4];
    ImageView[] s_list = new ImageView[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        b_one = findViewById(R.id.b_one);
        v_list[0] = findViewById(R.id.v_one);
        v_list[1] = findViewById(R.id.v_two);
        v_list[2] = findViewById(R.id.v_three);
        v_list[3] = findViewById(R.id.v_four);
        c_one = findViewById(R.id.c_one);
        s_list[0] = findViewById(R.id.s_one);
        s_list[1] = findViewById(R.id.s_two);
        s_list[2] = findViewById(R.id.v_three);
        s_list[3] = findViewById(R.id.s_four);


        resultMap = (HashMap<String, String>) (getIntent().getSerializableExtra("resultMap"));
        bread = resultMap.get("bread");
        vegetable = resultMap.get("vegetable");
        cheese = resultMap.get("cheese");
        sauce = resultMap.get("sauce");

        System.out.println("bread : " + bread + ", veget : " + vegetable + ", cheese : " + cheese + ", sauce : " + sauce);

        String[] vegetToken = vegetable.split(",");
        String[] sauceToken = sauce.split(",");

        if(bread.equals("화이트 브레드")) {
            b_one.setImageResource(R.drawable.white_bread);
        } else if (bread.equals("허니 오트 브레드")) {
            b_one.setImageResource(R.drawable.honey_oat_bread);
        } else if (bread.equals("플랫 브레드")) {
            b_one.setImageResource(R.drawable.flat_bread);
        }

        if(cheese.equals("아메리칸 치즈")) {
            c_one.setImageResource(R.drawable.american_cheese);
        } else if (cheese.equals("모짜렐라 치즈")) {
            c_one.setImageResource(R.drawable.mozza_cheese);
        } else if (cheese.equals("슈레드 치즈")) {
            c_one.setImageResource(R.drawable.shured_cheese);
        }


        for (int i=0; i<vegetToken.length; i++) {
            if(vegetToken[i].equals("양상추")) {
                v_list[i].setImageResource(R.drawable.lettuce_veget);
            } else if (vegetToken[i].equals("피클")) {
                v_list[i].setImageResource(R.drawable.pickle_veget);
            } else if (vegetToken[i].equals("토마토")) {
                v_list[i].setImageResource(R.drawable.tomato_veget);
            } else if (vegetToken[i].equals("할라피뇨")) {
                v_list[i].setImageResource(R.drawable.jalapenos_veget);
            } else if (vegetToken[i].equals("올리브")) {
                v_list[i].setImageResource(R.drawable.olive_veget);
            }
        }

        for (int i=0; i<sauceToken.length; i++) {
            if(sauceToken[i].equals("허니머스타드")) {
                s_list[i].setImageResource(R.drawable.honeymustard_sauce);
            } else if (sauceToken[i].equals("핫 칠리")) {
                s_list[i].setImageResource(R.drawable.hot_chiili_sauce);
            } else if (sauceToken[i].equals("마요네즈")) {
                s_list[i].setImageResource(R.drawable.mayo_sauce);
            }
        }





    }
}