package com.example.hl.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Button bt0;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button delete;
    private Button allclean;
    private Button tenToTwo;
    private Button twoToTen;
    private Button twoToEight;
    private Button eightToTwo;
    private Button eightToTen;
    private Button tenToEight;
    private EditText input;
    private EditText output ;
    private String existedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt0 = (Button)findViewById(R.id.zero);
        bt1 = (Button)findViewById(R.id.one);
        bt2 = (Button)findViewById(R.id.two);
        bt3 = (Button)findViewById(R.id.three);
        bt4 = (Button)findViewById(R.id.four);
        bt5 = (Button)findViewById(R.id.five);
        bt6 = (Button)findViewById(R.id.six);
        bt7 = (Button)findViewById(R.id.seven);
        bt8 = (Button)findViewById(R.id.eight);
        bt9 = (Button)findViewById(R.id.nine);
        delete = (Button)findViewById(R.id.delete);
        allclean = (Button)findViewById(R.id.clean);
        tenToTwo = (Button)findViewById(R.id.tenToTwo);
        twoToTen = (Button)findViewById(R.id.twoToTen);
        twoToEight = (Button)findViewById(R.id.twoToEight);
        eightToTwo = (Button)findViewById(R.id.eightToTwo);
        eightToTen = (Button)findViewById(R.id.eightToTen);
        tenToEight = (Button)findViewById(R.id.tenToEight);
        input = (EditText)findViewById(R.id.txtContent1);
        output = (EditText)findViewById(R.id.txtContent2);

        bt0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "0";
                input.setText(existedText);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "1";
                input.setText(existedText);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "2";
                input.setText(existedText);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "3";
                input.setText(existedText);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "4";
                input.setText(existedText);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "5";
                input.setText(existedText);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "6";
                input.setText(existedText);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "7";
                input.setText(existedText);
            }
        });
        bt8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "8";
                input.setText(existedText);
            }
        });
        bt9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                existedText += "9";
                input.setText(existedText);
            }
        });
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                if(existedText.length() > 1){
                    existedText = existedText.substring(0, existedText.length() - 1);
                }else{
                    existedText = null;
                }
                input.setText(existedText);
            }
        });
        allclean.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                input.setText(null);
                output.setText(null);
            }
        });
        //二进制转十进制
        twoToTen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                int needChange = Integer.parseInt(existedText);
                output.setText(Double.toString(BinaryToDecimal(needChange)));
            }
        });
        //十进制转二进制
        tenToTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                int needChange = Integer.parseInt(existedText);
                output.setText(toBinary(needChange));
            }
        });
        //二进制转八进制
        twoToEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                int needChange1 = Integer.parseInt(existedText);
                String s1 = Double.toString(BinaryToDecimal(needChange1));//先二进制转十进制
                existedText = s1;
                double midnum1 = Double.parseDouble(existedText);
                int needChange2 = (int)midnum1;
                output.setText(Integer.toString(needChange2,8));
            }
        });
        //八进制转二进制
        eightToTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                String s2 = Integer.valueOf(existedText,8).toString();//先八进制转十进制
                existedText = s2;
                double midnum2 = Double.parseDouble(s2);
                int needChange = (int) midnum2;
                output.setText(toBinary(needChange));
            }
        });
        //八进制转十进制
        eightToTen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                output.setText(Integer.valueOf(existedText,8).toString());
            }
        });
        //十进制转八进制
        tenToEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                existedText = input.getText().toString();
                int needChange = Integer.parseInt(existedText);
                output.setText(Integer.toString(needChange,8));
            }
        });

    }

    private static String toBinary(int a){
        String str = "";
        Stack s = new Stack();
        while(a != 0){
            s.push(a % 2);
            a = a / 2;
        }
        while(!s.empty()){
            str += s.pop();
        }
        return str;
    }
    private static double BinaryToDecimal(int binarynumber){
        double decimal = 0;
        int p = 0;
        while(true){
            if(binarynumber == 0){
                break;
            }else{
                int temp = binarynumber % 10;
                decimal += temp * Math.pow(2,p);
                binarynumber = binarynumber / 10;
                p++;
            }
        }
        return  decimal;
    }
}
