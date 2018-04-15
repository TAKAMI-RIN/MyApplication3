package com.example.tohsaka.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt = (Button)findViewById(R.id.button4);
        bt.setOnClickListener(btlist);
    }
//bluetooth control
    private void data(){

    }

    private Button.OnClickListener btlist = new Button.OnClickListener() {
        public void onClick(View v) {
            EditText edtA =  findViewById(R.id.editText);
            String strA = edtA.getText().toString();
            double Kp = strA.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strA);
            EditText edtB =  findViewById(R.id.editText2);
            String strB = edtB.getText().toString();
            double Ki = strB.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strB);
            EditText edtC =  findViewById(R.id.editText3);
            String strC = edtC.getText().toString();
            double Kd = strC.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strC);

        }
    };

}
