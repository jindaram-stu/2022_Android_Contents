package com.daelim;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.daelim.survey.BreadActivity;

// Need to Clear mode
public class InitActivity extends AppCompatActivity {

    InitActivity activity;
    Button bt_calculator, bt_next, bt_survey, bt_listView, bt_sp;
    TextView tv_value, tv_from;


    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_calculator:
                    Intent Calculintent = new Intent(activity, CalculatorActivity.class);
                    startActivity(Calculintent);
                    break;
                case R.id.bt_next:

                    Intent Nextintent = new Intent(activity, NextActivity.class);
                    startActivityForResult(Nextintent,0);
                    break;
                case R.id.bt_survey:
                    Intent surveyIntent = new Intent(activity, BreadActivity.class);
                    startActivity(surveyIntent);
                    break;
                case R.id.bt_listview:
                    Intent listViewIntent = new Intent(activity, ListViewActivity.class);
                    startActivity(listViewIntent);
                    break;
                case R.id.bt_sp:
                    Intent spIntent = new Intent(activity, SharedPreferencesActivity.class);
                    startActivity(spIntent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        activity = this;
        bt_calculator = findViewById(R.id.bt_calculator);
        bt_next = findViewById(R.id.bt_next);
        bt_survey = findViewById(R.id.bt_survey);
        bt_listView = findViewById(R.id.bt_listview);
        bt_sp = findViewById((R.id.bt_sp));


        bt_calculator.setOnClickListener(click);
        bt_next.setOnClickListener(click);
        bt_survey.setOnClickListener(click);;
        bt_listView.setOnClickListener(click);
        bt_sp.setOnClickListener(click);

        tv_value = findViewById(R.id.tv_value);
        tv_from = findViewById(R.id.tv_from);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("!!!",data.getStringExtra("nextValue"));
        if(resultCode != RESULT_OK) {
            System.out.println("destory");
            return;
        }
        String fromActivity = data.getStringExtra("fromActivity");
        String resultData = data.getStringExtra("nextValue");
        tv_from.setText("From : " + fromActivity);
        tv_value.setText("Value : " + resultData);

    }
}