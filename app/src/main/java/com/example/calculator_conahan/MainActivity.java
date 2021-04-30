package com.example.calculator_conahan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int step;

    String num1;
    String num2;
    String op;

    TextView text;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;

    Button c;
    Button ce;

    Button multiply;
    Button divide;
    Button add;
    Button subtract;
    Button equals;
    Button decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);

        num1 = "";
        num2 = "";

        zero = findViewById(R.id.button0);
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);

        c = findViewById(R.id.c);
        ce = findViewById(R.id.ce);

        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        add = findViewById(R.id.plus);
        subtract = findViewById(R.id.minus);
        equals = findViewById(R.id.equals);
        decimal = findViewById(R.id.decimal);

        step = 1;

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("0",step);

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("1",step);

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("2",step);

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("3",step);

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("4",step);

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("5",step);

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("6",step);

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("7",step);

            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("8",step);

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                concatNum("9",step);

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (step % 2 != 0){
                    num1 = "";
                }
                else{
                    num2 = "";
                }
                text.setText("");

            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                num1 = "";
                num2 = "";
                text.setText("");
                step = 1;

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (step % 2 != 0){
                    op = "*";
                    step++;
                }
                else{
                    num1 = String.valueOf(calculate(num1,num2,op));
                    num2 = "";
                    text.setText(num1);
                }

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (step % 2 != 0){
                    op = "/";
                    step++;
                }
                else{
                    num1 = String.valueOf(calculate(num1,num2,op));
                    num2 = "";
                    text.setText(num1);
                }

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (step % 2 != 0){
                    op = "+";
                    step++;
                }
                else{
                    num1 = String.valueOf(calculate(num1,num2,op));
                    num2 = "";
                    text.setText(num1);
                }

            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (step % 2 != 0){
                    op = "-";
                    step++;
                }
                else{
                    num1 = String.valueOf(calculate(num1,num2,op));
                    num2 = "";
                    text.setText(num1);
                }

            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                num1 = String.valueOf(calculate(num1,num2,op));
                num2 = "";
                text.setText(num1);

            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (step % 2 != 0){
                    num1 = num1 + ".";
                    text.setText(num1);
                }
                else{
                    num2 = num2 + ".";
                    text.setText(num2);
                }

            }
        });

    }

    public void concatNum(String digit, int step){
            if (step % 2 != 0){
                num1 = num1 + digit;
                text.setText(num1);
            }
            else{
                num2 = num2 + digit;
                text.setText(num2);
            }
    }

    public double calculate(String num1Txt, String num2Txt, String op) {

        double num1 = Double.parseDouble(num1Txt);
        double num2 = Double.parseDouble(num2Txt);

        switch (op) {

            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            default:
                return -1;

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){

        super.onSaveInstanceState(outState);

        outState.putString("num1",num1);
        outState.putString("num2",num2);
        outState.putString("op",op);
        outState.putInt("step",step);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){

        super.onRestoreInstanceState(savedInstanceState);

        num1 = savedInstanceState.getString("num1");
        num2 = savedInstanceState.getString("num2");
        op = savedInstanceState.getString("op");
        step = savedInstanceState.getInt("step");

        if (step % 2 != 0 || num2.equals("")){
            text.setText(num1);
        }
        else{
            text.setText(num2);
        }
    }
}