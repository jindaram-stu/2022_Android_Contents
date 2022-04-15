package com.daelim;


import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPreferencesActivity extends AppCompatActivity {

    Button bt_save, bt_confirm;
    EditText et_sp;
    SharedPreferencesActivity activity;

    public void showDialogWithPositive(Context context, String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        return;
                    }
                })
                .create()
                .show();
    }

    public void showDialog(Context context,String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .create()
                .show();
    }

    public SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences("test_sp", Context.MODE_PRIVATE);
    }

    public void putStringInSp(Context context,String key,String value) {
        SharedPreferences sp = getSharedPreference(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public String getStringInSp(Context context,String key) {
        SharedPreferences sp = getSharedPreference(context);
        return sp.getString(key,"");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        et_sp = findViewById(R.id.et_sp);
        bt_save = findViewById(R.id.bt_save);
        bt_confirm = findViewById(R.id.bt_confirm);
        activity = this;

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed_value = et_sp.getText().toString();
                if (ed_value.equals("") || ed_value == null){
                    showDialogWithPositive(activity,"오류","값이 비어있습니다.");
                    return;
                }
                putStringInSp(activity,"test_value",ed_value);
                et_sp.setText("");
                showDialogWithPositive(activity,"성공","값이 성공적으로 저장되었습니다.");

            }
        });

        bt_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = getStringInSp(activity,"test_value");
                showDialog(activity,"값 확인",value);
            }
        });
    }
}