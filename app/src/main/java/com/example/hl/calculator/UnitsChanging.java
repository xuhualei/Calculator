package com.example.hl.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UnitsChanging extends AppCompatActivity {
    String existedText;
    double meter,decimetre,centimeter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units_changing);

        final EditText meterinput = (EditText)findViewById(R.id.meter);//米输入
        final EditText decimetreinput = (EditText)findViewById(R.id.decimetre);//分米输入
        final EditText centimeterinput = (EditText)findViewById(R.id.centimeter);//厘米输入
        Button btcal = (Button)findViewById(R.id.cal);
        Button btbackspace = (Button)findViewById(R.id.backspace);
        btbackspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                meterinput.setText(null);
                decimetreinput.setText(null);
                centimeterinput.setText(null);
            }
        });

        btcal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(meterinput.getText().toString().length() != 0 &&
                        decimetreinput.getText().toString().length() == 0 &&
                        centimeterinput.getText().toString().length()== 0){
                    existedText = meterinput.getText().toString();
                    meter = Double.parseDouble(existedText);
                    decimetre = meter * 10;
                    centimeter = meter * 100;
                    decimetreinput.setText(Double.toString(decimetre));
                    centimeterinput.setText(Double.toString(centimeter));
                }
                else if(meterinput.getText().toString().length() == 0 &&
                        decimetreinput.getText().toString().length() != 0 &&
                        centimeterinput.getText().toString().length()== 0){
                    existedText = decimetreinput.getText().toString();
                    decimetre = Double.parseDouble(existedText);
                    meter = decimetre / 10;
                    centimeter = decimetre * 10;
                    meterinput.setText(Double.toString(meter));
                    centimeterinput.setText(Double.toString(centimeter));
                }
                else if(meterinput.getText().toString().length() == 0 &&
                        decimetreinput.getText().toString().length() == 0 &&
                        centimeterinput.getText().toString().length()!= 0){
                    existedText = centimeterinput.getText().toString();
                    centimeter = Double.parseDouble(existedText);
                    meter = centimeter / 100;
                    decimetre = centimeter / 10;
                    decimetreinput.setText(Double.toString(decimetre));
                    meterinput.setText(Double.toString(meter));
                }else{
                    meterinput.setText(null);
                    decimetreinput.setText(null);
                    centimeterinput.setText(null);
                    Toast.makeText(UnitsChanging.this, "每一次只能输入米或者分米或者厘米哦", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
