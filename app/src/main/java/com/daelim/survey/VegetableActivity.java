package com.daelim.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.daelim.R;

import java.util.HashMap;

public class VegetableActivity extends AppCompatActivity {

    Button nb_vegetable;
    CheckBox[] checkBoxList = new CheckBox[5];
    String vegetableList = "";
    HashMap<String,String> resultMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);

        Intent beIntent = getIntent();
        resultMap = (HashMap<String,String>)beIntent.getSerializableExtra("resultMap");

        checkBoxList[0] = findViewById(R.id.lettuce);
        checkBoxList[1] = findViewById(R.id.pickle);
        checkBoxList[2] = findViewById(R.id.tomato);
        checkBoxList[3] = findViewById(R.id.hala);
        checkBoxList[4] = findViewById(R.id.olive);

        nb_vegetable = findViewById(R.id.nb_vegetable);

        nb_vegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vegetableList = "";
                for (int i=0; i<checkBoxList.length; i++) {
                    if(checkBoxList[i].isChecked()) {
                        vegetableList += checkBoxList[i].getText().toString() + ",";
                    }
                }
                vegetableList = vegetableList.substring(0,vegetableList.length()-1);
                System.out.println(vegetableList);
                resultMap.put("vegetable",vegetableList);

                Intent intent = new Intent(getApplicationContext(), CheeseActivity.class);
                intent.putExtra("resultMap",resultMap);
                startActivity(intent);

            }
        });
        // nb_vegetable.setOnClickListener(new SurveyNextButton(getApplicationContext(),CheeseActivity.class));
    }
}