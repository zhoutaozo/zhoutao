package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit_text;
    boolean clear_flag;

    String etinput;
    Button btn_back;
    Button btn_clear;
    Button btn_num0;
    Button btn_num1;
    Button btn_num2;
    Button btn_num3;
    Button btn_num4;
    Button btn_num5;
    Button btn_num6;
    Button btn_num7;
    Button btn_num8;
    Button btn_num9;
    Button btn_dot;
    Button btn_add;
    Button btn_sub;
    Button btn_mul;
    Button btn_divide;
    Button btn_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        edit_text = findViewById(R.id.edit_text);
        btn_num0 = findViewById(R.id.btn_num0);
        btn_num1 = findViewById(R.id.btn_num1);
        btn_num2 = findViewById(R.id.btn_num2);
        btn_num3 = findViewById(R.id.btn_num3);
        btn_num4 = findViewById(R.id.btn_num4);
        btn_num5 = findViewById(R.id.btn_num5);
        btn_num6 = findViewById(R.id.btn_num6);
        btn_num7 = findViewById(R.id.btn_num7);
        btn_num8 = findViewById(R.id.btn_num8);
        btn_num9 = findViewById(R.id.btn_num9);
        btn_clear = findViewById(R.id.btn_clear);
        btn_back = findViewById(R.id.btn_back);
        btn_dot = findViewById(R.id.btn_dot);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_divide = findViewById(R.id.btn_divide);
        btn_equal = findViewById(R.id.btn_equal);
        btn_mul = findViewById(R.id.btn_mul);
        btn_num6.setOnClickListener(this);
        btn_num0.setOnClickListener(this);
        btn_num1.setOnClickListener(this);
        btn_num2.setOnClickListener(this);
        btn_num3.setOnClickListener(this);
        btn_num4.setOnClickListener(this);
        btn_num5.setOnClickListener(this);
        btn_num7.setOnClickListener(this);
        btn_num8.setOnClickListener(this);
        btn_num9.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        etinput = edit_text.getText().toString();
        String etTemp = "";
        switch(v.getId()){
            case R.id.btn_num0:
            case R.id.btn_num1:
            case R.id.btn_num2:
            case R.id.btn_num3:
            case R.id.btn_num4:
            case R.id.btn_num5:
            case R.id.btn_num6:
            case R.id.btn_num7:
            case R.id.btn_num8:
            case R.id.btn_num9:
            case R.id.btn_dot:
                if(clear_flag){ etClear(); }
                etTemp = etinput + ((Button)v).getText();
                showText(etTemp);
           break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_divide:
                if(clear_flag){ etClear(); }
                etTemp = etinput +" "+((Button)v).getText()+" ";
                showText(etTemp);
                break;

            case R.id.btn_back:
                if(clear_flag){
                    etClear();
                }else if(etinput!=null&&!etinput.equals(" ")){
                    etTemp = etinput.substring(0,etinput.length()-1);
                    showText(etTemp);
                }
                break;
            case R.id.btn_clear:
                etClear();
                break;
            case R.id.btn_equal:
                getResult();
                clear_flag = true;
                break;

            default:
                break;
        }

    }

    private void showText(String content) {
        edit_text.setText(content);
        edit_text.setSelection(content.length());

    }

    private void etClear() {
        clear_flag = false;
        etinput = "";
        edit_text.setText("");
    }
    private void getResult(){
        String dataln = etinput;
        double result = 0;
        if(dataln==null||dataln.equals("")){
            return;
        }
        if(!dataln.contains(" ")){
            return;
        }
        String str1 = dataln.substring(0,dataln.indexOf(" "));
        String operator = dataln.substring(dataln.indexOf(" ")+1,dataln.indexOf(" ")+2);
        String str2 = dataln.substring(dataln.indexOf(" ")+3);
        double data1 = Double.parseDouble(str1);
        double data2 = Double.parseDouble(str2);
        switch(operator){
            case"+":
                result=data1+data2;
                break;
            case"-":
                result=data1-data2;
                break;
            case"*":
                result=data1*data2;
                break;
            case"/":
                if(data2==0){
                    etClear();
                    break;
                }
                result=data1/data2;
                break;
        }
        if(!str1.contains(".")&&!str2.contains(".")&&!operator.equals("/")){
            edit_text.setText(dataln+"="+(int)result);
            return;
        }
        edit_text.setText(dataln+"="+result);
    }
}