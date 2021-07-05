package com.app.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.calculator.Calculator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvOutput;

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnDot;
    private Button btnSin, btnCos, btnTan;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnEq;
    private Button btnClear, btnBackspace;

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extractControls();

        calculator = new Calculator();
        String result = calculator.getResult();
        tvOutput.setText(result);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String text = button.getText().toString();

        calculator.buttonClicked(text);
        String result = calculator.getResult();
        tvOutput.setText(result);
    }

    private void extractControls() {
        tvOutput = findViewById(R.id.tvOutput);
        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btnDot = findViewById(R.id.btnDot);
        btnDot.setOnClickListener(this);
        btnSin = findViewById(R.id.btnSin);
        btnSin.setOnClickListener(this);
        btnCos = findViewById(R.id.btnCos);
        btnCos.setOnClickListener(this);
        btnTan = findViewById(R.id.btnTan);
        btnTan.setOnClickListener(this);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);
        btnMul = findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnDiv = findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        btnEq = findViewById(R.id.btnEq);
        btnEq.setOnClickListener(this);
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnBackspace = findViewById(R.id.btnBack);
        btnBackspace.setOnClickListener(this);
    }


}



