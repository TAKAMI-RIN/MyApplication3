package com.example.tohsaka.myapplication3;
//Author:TOOSAKA
//TOOSAKA is G10581117 as 李秉翰
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.View;
//import android.app.Activity;
//import android.support.v7.widget.ViewUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Button Button2;
    private Button RButton;
    //int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Random r = new Random();
        //number = r.nextInt(10) + 1;
    }

    public void onclickMethod2(View v){
        EditText edtA = (EditText) findViewById(R.id.editText);
        EditText edtB = (EditText) findViewById(R.id.editText2);
        Spinner opr = (Spinner) findViewById(R.id.spinner);
        TextView tv = (TextView) findViewById(R.id.textView3);
        String strA = edtA.getText().toString();
        String strB = edtB.getText().toString();
        double a = strA.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strA);
        double b = strB.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strB);
        String ope = opr.getSelectedItem().toString();
        if(ope.charAt(0) == '+') tv.setText(""+(a+b));
        if(ope.charAt(0) == '-') tv.setText(""+(a-b));
        if(ope.charAt(0) == '*') tv.setText(""+(a*b));
        if(ope.charAt(0) == '/') tv.setText(""+(a/b));
    }
    public void onclickMethod3(View v){
        EditText edtA = (EditText) findViewById(R.id.editText);
        EditText edtB = (EditText) findViewById(R.id.editText2);
        Spinner opr = (Spinner) findViewById(R.id.spinner);
        TextView tv = (TextView) findViewById(R.id.textView3);
        String strA = edtA.getText().toString();
        String strB = edtB.getText().toString();
        double a = strA.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strA);
        double b = strB.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strB);
        String ope = opr.getSelectedItem().toString();
        if(ope.charAt(0) == '+') tv.setText(""+(a+b));
        if(ope.charAt(0) == '-') tv.setText(""+(a-b));
        if(ope.charAt(0) == '*') tv.setText(""+(a*b));
        if(ope.charAt(0) == '/') tv.setText(""+(a/b));
    }
    //public void onclickMethod(View v){
        //TextView tv = (TextView) findViewById(R.id.textView7);
        //Random r = new Random();
        //number = r.nextInt(10) + 1;
        //tv.setText("REDO");
    //}
}