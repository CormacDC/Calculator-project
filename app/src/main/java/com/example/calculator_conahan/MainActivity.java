package com.example.calculator_conahan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    double num1;
    double num2;
    String op;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }

    public double calculate(double num1, double num2, String op) {

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
}