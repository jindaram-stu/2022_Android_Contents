package com.daelim.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.daelim.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BreadActivity extends AppCompatActivity {

    HashMap<String,String> resultMap = new HashMap<>();
    Button nb_bread;
    RadioGroup rg_bread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread);
        rg_bread = findViewById(R.id.rg_bread);
        nb_bread = findViewById(R.id.nb_bread);
        nb_bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton abc = findViewById(rg_bread.getCheckedRadioButtonId());
                resultMap.put("bread",abc.getText().toString());

                Intent intent = new Intent(getApplicationContext(),VegetableActivity.class);
                intent.putExtra("resultMap",resultMap);
                startActivity(intent);
            }
        });
       // nb_bread.setOnClickListener(new SurveyNextButton(getApplicationContext(),VegetableActivity.class));
    }
}