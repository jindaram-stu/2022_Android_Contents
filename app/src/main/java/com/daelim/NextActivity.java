package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {
    Button pre;
    EditText ed_text;
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        pre = findViewById(R.id.bt_pre);
        ed_text = findViewById(R.id.ed_text_next);

        intent.putExtra("next_responseMessage","수신성공");
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("nextValue",ed_text.getText().toString());
                intent.putExtra("fromActivity","NextActivity");
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        intent.putExtra("nextValue",ed_text.getText().toString());
        intent.putExtra("fromActivity","NextActivity");
        setResult(RESULT_OK,intent);
        System.out.println("back pressed");
        finish();
        super.onBackPressed();
    }
}