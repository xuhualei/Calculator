package com.example.hl.calculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator extends AppCompatActivity implements View.OnClickListener{
    //数字
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    //运算符
    private Button plus;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button equal;
    //其他
    private Button percent;
    private Button point;
    private Button ac_btn;
    private Button delete;
    private Button bthelp;
    private Button btmenu;
    private Button btsin;
    private Button btcos;
    private Button bttan;
    private Button btlog;
    private Button square;//平方
    private Button evolution;//开方
    private Button left_bracket;
    private Button right_bracket;
    //结果
    private EditText resultText;
    //已经输入的字符
    private String existedText = "";
    //是否计算过
    private boolean isCounted = false;
    //括号计数
    int backet = 0;
    //字符计数,用于getbefore()和getnum()中
    int num = 0,nosqu = 0,nogen = 0,nopercent = 0, nosin = 0, nocos = 0, notan = 0, nolog = 0;
    public static Map pro = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initView();
        initEvent();
    }
    public void onClick(View v) {

        switch (v.getId()) {
            //其他运算符
            case R.id.help:
                Toast.makeText(Calculator.this, "这是帮助", Toast.LENGTH_LONG).show();
            case R.id.clear:
                existedText = resultText.getText().toString();
                if(existedText.length() > 1){
                    resultText.setText(existedText.substring(0, existedText.length() - 1));
                    if(getlast().equals("(")){
                        backet--;
                    }
                    if(getlast().equals(")")){
                       backet++;
                    }
                }else{
                    existedText = "0";
                }
                resultText.setText(existedText);
                break;

            case R.id.allclean:
                resultText.setText(null);
                break;
            //数字
            case R.id.zero:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "0";
                resultText.setText(existedText);
                break;

            case R.id.one:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "1";
                resultText.setText(existedText);
                break;

            case R.id.two:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "2";
                resultText.setText(existedText);
                break;

            case R.id.three:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "3";
                resultText.setText(existedText);
                break;

            case R.id.four:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "4";
                resultText.setText(existedText);
                break;

            case R.id.five:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "5";
                resultText.setText(existedText);
                break;

            case R.id.six:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "6";
                resultText.setText(existedText);
                break;

            case R.id.seven:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "7";
                resultText.setText(existedText);
                break;

            case R.id.eight:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "8";
                resultText.setText(existedText);
                break;

            case R.id.nine:
                if (isCounted) {
                    resultText.setText(null);
                    isCounted = false;
                }
                existedText = resultText.getText().toString();
                existedText += "9";
                resultText.setText(existedText);
                break;

            //运算符
            case R.id.add:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("=") || (getlast().equals("?")))) {
                    break;
                }
               existedText = resultText.getText().toString();
                existedText += "+";
                resultText.setText(existedText);
                isCounted = false;
                break;

             case R.id.subtract:
                 if((getlast().equals("+"))|| (getlast().equals("-")) ||
                         (getlast().equals("×")) || (getlast().equals("÷")) ||
                         (getlast().equals(".")) || (getlast().equals("(")) ||
                         (getlast().equals("=")) || (getlast().equals("?"))) {
                     break;
                 }
                 existedText = resultText.getText().toString();
                 existedText += "-";
                 resultText.setText(existedText);
                 isCounted = false;
                 break;

            case R.id.multiply:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("=")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                existedText += "×";
                resultText.setText(existedText);
                isCounted = false;
                break;

            case R.id.divide:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("=")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                existedText += "÷";
                resultText.setText(existedText);
                isCounted = false;
                break;

            case R.id.dengyu:
                existedText = resultText.getText().toString();
                double result = 0.0;
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("="))) {
                    resultText.setText("式子未完成");
                }else if(backet != 0){
                    resultText.setText("括号不平衡");
                }else if(((!getlast().equals("+")) && (!getlast().equals("-")) &&
                        (!getlast().equals("×")) && (!getlast().equals("÷")) &&
                        (!getlast().equals(".")) && (!getlast().equals("(")) &&
                        (!getlast().equals("√")) && (!getlast().equals("="))) &&
                        backet == 0){
                    result = getResult(existedText);
                    resultText.setText(Double.toString(result));
                }
                isCounted = true;
                break;

            //特殊运算符
            case R.id.sin:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals(")")) || (getlast().equals("²")) ||
                        (getlast().equals("%")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                double resultsin = Double.parseDouble(getbefore(existedText));
                double sinchange = 180/(Math.PI) * resultsin;
                resultsin = Math.sin(sinchange);
                nosin =  getnum(existedText);
                existedText = existedText.substring(0,existedText.length()- nosin) + Double.toString(resultsin);
                resultText.setText(existedText);
                nosin = 0;
                num = 0;
                isCounted = false;
                break;

            case R.id.cos:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals(")")) || (getlast().equals("²")) ||
                        (getlast().equals("%")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                double resultcos = Double.parseDouble(getbefore(existedText));
                resultcos = Math.cos(resultcos);
                nocos =  getnum(existedText);
                existedText = existedText.substring(0,existedText.length()- nocos) + Double.toString(resultcos);
                resultText.setText(existedText);
                nocos = 0;
                num = 0;
                isCounted = false;
                break;
            case R.id.tan:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals(")")) || (getlast().equals("²")) ||
                        (getlast().equals("%")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                double resulttan = Double.parseDouble(getbefore(existedText));
                resulttan = Math.tan(resulttan);
                notan =  getnum(existedText);
                existedText = existedText.substring(0,existedText.length()- notan) + Double.toString(resulttan);
                resultText.setText(existedText);
                notan = 0;
                num = 0;
                isCounted = false;
                break;

            case R.id.log:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals(")")) || (getlast().equals("²")) ||
                        (getlast().equals("%")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                double resultlog = Double.parseDouble(getbefore(existedText));
                resultlog = Math.log(resultlog);
                nolog =  getnum(existedText);
                existedText = existedText.substring(0,existedText.length()- nolog) + Double.toString(resultlog);
                resultText.setText(existedText);
                nolog = 0;
                num = 0;
                isCounted = false;
                break;

            case R.id.pingfang:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals("²")) || (getlast().equals("%")) ||
                        (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                double resultsqu = Double.parseDouble(getbefore(existedText));
                resultsqu = resultsqu * resultsqu;
                nosqu =  getnum(existedText);
                existedText = existedText.substring(0,existedText.length()- nosqu) + Double.toString(resultsqu);
                resultText.setText(existedText);
                nosqu = 0;
                num = 0;
                isCounted = false;
                break;

            case R.id.genhao:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                    (getlast().equals("×")) || (getlast().equals("÷")) ||
                    (getlast().equals(".")) || (getlast().equals(")")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals("²")) || (getlast().equals("%")) ||
                        (getlast().equals("(")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                double resultgenhao = Double.parseDouble(getbefore(existedText));
                resultgenhao = Math.sqrt(resultgenhao);
                nogen =  getnum(existedText);
                existedText = existedText.substring(0,existedText.length()- nogen) + Double.toString(resultgenhao);
                resultText.setText(existedText);
                nogen = 0;
                num = 0;
                isCounted = false;
                break;

            case R.id.zuokuohao:
                if((getlast().equals("."))|| (getlast().equals("(")) ||
                        (getlast().equals(")")) || (getlast().equals("²")) ||
                        (getlast().equals("%")) || (getlast().equals("=")) ||
                        (getlast().equals("√")) || (getlast().equals("0"))||
                        (getlast().equals("1")) || (getlast().equals("2"))||
                        (getlast().equals("3"))|| (getlast().equals("4")) ||
                        (getlast().equals("5")) || (getlast().equals("6")) ||
                        (getlast().equals("7")) || (getlast().equals("8")) ||
                        (getlast().equals("9"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                if (existedText.equals(null)) {
                    return;
                }
                existedText += "(";
                backet++;
                resultText.setText(existedText);
                isCounted = false;
                break;

            case R.id.youkuohao:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals(")")) || (getlast().equals("²")) ||
                        (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                existedText += ")";
                backet--;
                resultText.setText(existedText);
                isCounted = false;
                break;

            case R.id.point:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals(")")) || (getlast().equals("²")) ||
                        (getlast().equals("%")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                existedText += ".";
                resultText.setText(existedText);
                isCounted = false;
                break;

            case R.id.percent:
                if((getlast().equals("+"))|| (getlast().equals("-")) ||
                        (getlast().equals("×")) || (getlast().equals("÷")) ||
                        (getlast().equals(".")) || (getlast().equals("(")) ||
                        (getlast().equals("√")) || (getlast().equals("=")) ||
                        (getlast().equals(")")) || (getlast().equals("²")) ||
                        (getlast().equals("%")) || (getlast().equals("?"))) {
                    break;
                }
                existedText = resultText.getText().toString();
                double rsultpercent = Double.parseDouble(getbefore(existedText));
                rsultpercent = rsultpercent/100;
                nopercent =  getnum(existedText);
                existedText = existedText.substring(0,existedText.length()- nopercent) + Double.toString(rsultpercent);
                resultText.setText(existedText);
                nopercent = 0;
                num = 0;
                isCounted = false;
                break;
        }
    }
    //取输入字符串的最后一个字符，用来和上一位进行比较
    private String getlast(){
        existedText = resultText.getText().toString();
        if(existedText.length()==0){
            return "?";
        }
        return existedText.substring(existedText.length() - 1,existedText.length());
    }

    //取前一个数
    private String getbefore(String str) {
        String numre = "";
        Stack s = new Stack();
        existedText = str;
        while (str.substring(str.length() - 1, str.length()).equals("0") ||
                str.substring(str.length() - 1, str.length()).equals("1") ||
                str.substring(str.length() - 1, str.length()).equals("2") ||
                str.substring(str.length() - 1, str.length()).equals("3") ||
                str.substring(str.length() - 1, str.length()).equals("4") ||
                str.substring(str.length() - 1, str.length()).equals("5") ||
                str.substring(str.length() - 1, str.length()).equals("6") ||
                str.substring(str.length() - 1, str.length()).equals("7") ||
                str.substring(str.length() - 1, str.length()).equals("8") ||
                str.substring(str.length() - 1, str.length()).equals("9") ||
                str.substring(str.length() - 1, str.length()).equals(".")) {
            s.push(str.substring(str.length() - 1, str.length()));
            str = str.substring(0, str.length() - 1);
            if (str.length() == 0) {
                return existedText;
            }
        }
        int size = s.size();
        for (int i = 0; i < size; i++) {
            numre += s.pop();
        }
        return numre;
    }

    //前一个数有多少位
    private int getnum(String str){
        existedText = str;
        while(str.substring(str.length()-1,str.length()).equals("0") ||
                str.substring(str.length()-1,str.length()).equals("1") ||
                str.substring(str.length()-1,str.length()).equals("2") ||
                str.substring(str.length()-1,str.length()).equals("3") ||
                str.substring(str.length()-1,str.length()).equals("4") ||
                str.substring(str.length()-1,str.length()).equals("5") ||
                str.substring(str.length()-1,str.length()).equals("6") ||
                str.substring(str.length()-1,str.length()).equals("7") ||
                str.substring(str.length()-1,str.length()).equals("8") ||
                str.substring(str.length()-1,str.length()).equals("9") ||
                str.substring(str.length()-1,str.length()).equals(".")){
                    str = str.substring(0,str.length()-1);
                    if(str.length() == 0){
                        return existedText.length();
                    }else{
                        num++;
                    }
        }
         return num;
    }

    public static void init(){
        pro.put('+',1);
        pro.put('-',1);
        pro.put('×',2);
        pro.put('÷',2);
    }

    public static int getIndex(String str){
        int index1 = (str.indexOf("+") == -1 ? str.length() : str.indexOf("+"));
        int index2 = (str.indexOf("-") == -1 ? str.length() : str.indexOf("-"));
        int index3 = (str.indexOf("×") == -1 ? str.length() : str.indexOf("×"));
        int index4 = (str.indexOf("÷") == -1 ? str.length() : str.indexOf("÷"));
        int index = index1 < index2 ? index1 : index2;
        index = index < index3 ? index : index3;
        index = index < index4 ? index : index4;
        if(index2 == index1+1){
            return index1;
        }
        if(index2 == index3+1){
            return index3;
        }
        if(index2 == index4+1){
            return index4;
        }
        return index;
    }

    public static double calculate(double num1,double num2,char op){
        switch(op){
            case '+':
                if(num1>0 && num2>0){
                    return num1 + num2;
                }
                if(num1<0 && num2>0) {
                    return num2 - Math.abs(num1);
                }

            case '-':
                if(num1 >= num2){
                    return num1 - num2;
                }else{
                    return -(num2-num1);
                }

            case '×':
                if(num1>0 && num2>0) {
                    return num1 * num2;
                }
                if((num1>0 && num2<0)){
                    return -((Math.abs(num2)) * num1);
                }
                if((num1<0 && num2>0)){
                    return -((Math.abs(num1)) * num2);
                }
            default:
                if(num2 != 0) {
                    return num1 / num2;
                }else{
                    return 0;
                }
        }
    }
    //计算过程
    public static double fun(String str){
        init();
        Stack stack1 = new Stack();//操作数栈
        Stack stack2 = new Stack();//运算符栈
        int fop = 0;
        while(str.length() > 0){
            int index = getIndex(str);
            stack1.push(Double.parseDouble(str.substring(0,index)));
            if (index != str.length()){
                char op = str.charAt(index);
                str = str.substring(index+1);
                while(true){
                    if((int)pro.get(op) > fop){
                        stack2.push(op);
                        fop = (int)pro.get(op);
                        break;
                    }else{
                        double num2 = (double)stack1.pop();
                        double num1 = (double)stack1.pop();
                        double result = calculate(num1,num2,(char)stack2.pop());
                        stack1.push(result);//把结果入栈
                        if(stack2.size() == 0){
                            stack2.push(op);
                            fop = (int)pro.get(op);
                            break;
                        }
                        char cop = (char)stack2.pop();
                        fop = (int)pro.get(cop);
                        stack2.push(cop);
                    }
                }
            }else{
                break;
            }
        }
        while(stack2.size() != 0){
            double num2 = (double)stack1.pop();
            double num1 = (double)stack1.pop();
            char op = (char)stack2.pop();
            stack1.push(calculate(num1,num2,op));
        }
        double result = (double)stack1.pop();
        return result;
    }
    //计算结果
    public double getResult(String str){
        existedText = str;
        while(str.indexOf('(') != -1){
            int left = 0;
            int right = str.length();
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '('){
                    left = i;
                }
                if(str.charAt(i) == ')'){
                    right = i;
                    break;
                }
            }
            existedText = existedText.substring(left+1,right);
            str = str.substring(0,left) + Double.toString(fun(existedText)) + str.substring(right+1);
           existedText = str;
        }
        return fun(str);
    }

    //初始化控件
    private void initView(){
        //数字
        num0 = (Button)findViewById(R.id.zero);
        num1 = (Button)findViewById(R.id.one);
        num2 = (Button)findViewById(R.id.two);
        num3 = (Button)findViewById(R.id.three);
        num4 = (Button)findViewById(R.id.four);
        num5 = (Button)findViewById(R.id.five);
        num6 = (Button)findViewById(R.id.six);
        num7 = (Button)findViewById(R.id.seven);
        num8 = (Button)findViewById(R.id.eight);
        num9 = (Button)findViewById(R.id.nine);
        //运算符
        plus = (Button)findViewById(R.id.add);
        subtract = (Button)findViewById(R.id.subtract);
        multiply = (Button)findViewById(R.id.multiply);
        divide = (Button)findViewById(R.id.divide);
        equal = (Button)findViewById(R.id.dengyu);
        //其他
        percent = (Button)findViewById(R.id.percent);
        point = (Button)findViewById(R.id.point);
        ac_btn = (Button)findViewById(R.id.allclean);
        delete = (Button)findViewById(R.id.clear);
        bthelp = (Button)findViewById(R.id.help);
        btmenu = (Button)findViewById(R.id.menu);
        btsin = (Button) findViewById(R.id.sin);
        btcos = (Button) findViewById(R.id.cos);
        bttan = (Button) findViewById(R.id.tan);
        btlog = (Button) findViewById(R.id.log);
        square = (Button)findViewById(R.id.pingfang);
        evolution = (Button)findViewById(R.id.genhao);
        left_bracket = (Button)findViewById(R.id.zuokuohao);
        right_bracket = (Button)findViewById(R.id.youkuohao);
        //结果
        resultText = (EditText)findViewById(R.id.txtContent);
        //已经输入的字符
        existedText = resultText.getText().toString();
    }
    //事件监听器
    private void initEvent(){
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        plus.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);

        bthelp.setOnClickListener(this);
        btmenu.setOnClickListener(this);
        point.setOnClickListener(this);
        percent.setOnClickListener(this);
        delete.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
        btsin.setOnClickListener(this);
        btcos.setOnClickListener(this);
        bttan.setOnClickListener(this);
        btlog.setOnClickListener(this);
        square.setOnClickListener(this);
        evolution.setOnClickListener(this);
        left_bracket.setOnClickListener(this);
        right_bracket.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.change) {
            Intent intent1=new Intent(Calculator.this,MainActivity.class);
            startActivity(intent1);
        }else if (id == R.id.units)
        {
            Intent intent2=new Intent(Calculator.this,UnitsChanging.class);
            startActivity(intent2);
        }

        return super.onOptionsItemSelected(item);
    }

}
