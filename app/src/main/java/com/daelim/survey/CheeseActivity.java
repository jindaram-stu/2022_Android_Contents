package com.daelim.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.daelim.R;

import java.util.HashMap;

public class CheeseActivity extends AppCompatActivity {

    Button nb_cheese;
    HashMap<String,String> resultMap;
    RadioGroup rg_cheese;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese);
        rg_cheese = findViewById(R.id.rg_cheese);
        resultMap = (HashMap<String, String>) (getIntent().getSerializableExtra("resultMap"));

        nb_cheese = findViewById(R.id.nb_cheese);
        nb_cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton abc = findViewById(rg_cheese.getCheckedRadioButtonId());
                resultMap.put("cheese",abc.getText().toString());

                Intent intent = new Intent(getApplicationContext(),SauceActivity.class);
                intent.putExtra("resultMap",resultMap);
                startActivity(intent);
            }
        });
        // nb_cheese.setOnClickListener(new SurveyNextButton(getApplicationContext(),SauceActivity.class));

    }
}