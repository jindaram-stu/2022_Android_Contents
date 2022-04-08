package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    private int currentResult = 0; // 계산 결과
    private Integer tv_value = null; // 연산기호를 눌렀을 때 TextView에 쓰여진 값.
    private String currentResultString = "";
    private String processResult = "";
    private String currentSign = "";
    private int currentValue;
    private Button one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,dupli,division, result,c;
    private TextView current,process;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        current = findViewById(R.id.current);
        process = findViewById(R.id.process);
        one = findViewById(R.id.one);
        one.setOnClickListener(click);
        two = findViewById(R.id.two);
        two.setOnClickListener(click);
        three = findViewById(R.id.three);
        three.setOnClickListener(click);
        four = findViewById(R.id.four);
        four.setOnClickListener(click);
        five = findViewById(R.id.five);
        five.setOnClickListener(click);
        six = findViewById(R.id.six);
        six.setOnClickListener(click);
        seven = findViewById(R.id.seven);
        seven.setOnClickListener(click);
        eight = findViewById(R.id.eight);
        eight.setOnClickListener(click);
        nine = findViewById(R.id.nine);
        nine.setOnClickListener(click);
        zero = findViewById(R.id.zero);
        zero.setOnClickListener(click);

        plus = findViewById(R.id.plus);
        plus.setOnClickListener(calculClick);
        minus = findViewById(R.id.minus);
        minus.setOnClickListener(calculClick);
        dupli = findViewById(R.id.dupli);
        dupli.setOnClickListener(calculClick);
        division = findViewById(R.id.division);
        division.setOnClickListener(calculClick);
        result = findViewById(R.id.result);
        result.setOnClickListener(calculClick);

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.one: updateCurentView(1); break;
                case R.id.two: updateCurentView(2); break;
                case R.id.three: updateCurentView(3); break;
                case R.id.four: updateCurentView(4); break;
                case R.id.five: updateCurentView(5); break;
                case R.id.six: updateCurentView(6); break;
                case R.id.seven: updateCurentView(7); break;
                case R.id.eight: updateCurentView(8); break;
                case R.id.nine: updateCurentView(9); break;
                case R.id.zero: updateCurentView(0); break;

            }
        }
    };

    View.OnClickListener calculClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tv_value = Integer.parseInt(current.getText().toString());

            if (tv_value != null) {
                switch(view.getId()) {
                    case R.id.plus:
                        isClickedSign("+",tv_value);
                        updateProcessView("+");
                        break;
                    case R.id.minus:
                        isClickedSign("-",tv_value);
                        updateProcessView("-");
                        break;
                    case R.id.dupli:
                        isClickedSign("*",tv_value);
                        updateProcessView("*");
                        break;
                    case R.id.division:
                        isClickedSign("/",tv_value);
                        updateProcessView("/");
                        break;
                    case R.id.result:
                        onResult(tv_value);

                }
            }
        }
    };

    public void updateCurentView(int number) {
        currentResultString += Integer.toString(number);
        current.setText(currentResultString);
    }

    public void isClickedSign(String mathSign, int currentNumber) {
        if (currentResult == 0) {
            currentResult += currentNumber;
            currentSign = mathSign;
        } else {
            if (currentSign.equals("+")) {
                currentResult += currentNumber;
                currentSign = mathSign;
            } else if(currentSign.equals("-")) {
                currentResult -= currentNumber;
                currentSign = mathSign;
            } else if(currentSign.equals("*")) {
                currentResult *= currentNumber;
                currentSign = mathSign;
            } else if(currentSign.equals("/")) {
                currentResult /= currentNumber;
                currentSign = mathSign;
            }
        }



    }

    public void updateProcessView(String mathSign) {
        if (!currentResultString.equals("")) {
            processResult += tv_value + mathSign;
            process.setText(processResult);
            current.setText(Integer.toString(currentResult));
            currentResultString = "";
            tv_value = null;
        } else if (currentResultString.equals("")) {
            processResult += tv_value + mathSign;
            process.setText(processResult);
            current.setText(Integer.toString(currentResult));
            currentResultString = "";
            tv_value = null;
        }
    }

    public void onResult(int tv_value) {
        if(currentSign.equals("+")) {
            processResult += tv_value;
            process.setText(processResult);
            currentResult += tv_value;
            current.setText(Integer.toString(currentResult));
        } else if (currentSign.equals("-")) {
            processResult += tv_value;
            process.setText(processResult);
            currentResult -= tv_value;
            current.setText(Integer.toString(currentResult));
        } else if (currentSign.equals("*")) {
            processResult += tv_value;
            process.setText(processResult);
            currentResult *= tv_value;
            current.setText(Integer.toString(currentResult));
        } else if (currentSign.equals("/")) {
            processResult += tv_value;
            process.setText(processResult);
            currentResult /= tv_value;
            current.setText(Integer.toString(currentResult));
        }
        settingInitialize();
    }

    public void settingInitialize() {
        currentResult = 0;
        tv_value = null;
        currentResultString = "";
        processResult = "";
        currentSign = "";
    }
}
