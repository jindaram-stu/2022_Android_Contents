package com.daelim.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.daelim.R;

import java.util.HashMap;

public class SauceActivity extends AppCompatActivity {
    SauceActivity activity;
    Button nb_sauce;
    CheckBox[] checkBoxList = new CheckBox[3];
    HashMap<String,String> resultMap;
    String sauceList = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauce);

        checkBoxList[0] = findViewById(R.id.honey_mustard);
        checkBoxList[1] = findViewById(R.id.hot_chilli);
        checkBoxList[2] = findViewById(R.id.mayo);

        activity = this;
        resultMap = (HashMap<String, String>) (getIntent().getSerializableExtra("resultMap"));
        System.out.println(resultMap.get("bread"));
        System.out.println(resultMap.get("vegetable"));
        System.out.println(resultMap.get("cheese"));
        nb_sauce = findViewById(R.id.nb_sauce);
        nb_sauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sauceList = "";
                for (int i=0; i<checkBoxList.length; i++) {
                    if (checkBoxList[i].isChecked()) {
                        sauceList += checkBoxList[i].getText().toString() + ",";
                    }
                }
                sauceList = sauceList.substring(0,sauceList.length()-1);
                System.out.println(sauceList);
                resultMap.put("sauce",sauceList);

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("resultMap",resultMap);
                startActivity(intent);

            }
        });
       // nb_sauce.setOnClickListener(new SurveyNextButton(getApplicationContext(),ResultActivity.class));
    }
}