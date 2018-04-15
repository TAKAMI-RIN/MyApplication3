package com.example.tohsaka.myapplication3;
//Author:TOOSAKA
//20180413:5
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;



public class MainActivity extends AppCompatActivity {
    private Button Button3;
    private Button Button2;
    private SharedPreferences prefs;
    public char ww = 1;
    //int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs =	getPreferences(MODE_PRIVATE);
        Button3 = (Button)findViewById(R.id.button3);
        Button3.setOnClickListener(btnRollDiceOnClickLis);
        Button2 = (Button)findViewById(R.id.button2);
        Button2.setOnClickListener(btnRollDiceOnClickLis2);
        //Random r = new Random();
        //number = r.nextInt(10) + 1;
    }

//    public void onclickMethod2(View v) {
//        //EditText edtA = (EditText) findViewById(R.id.editText);
//        EditText edtA =  findViewById(R.id.editText);
//        EditText edtB =  findViewById(R.id.editText2);
//        Spinner opr =  findViewById(R.id.spinner);
//        TextView tv =  findViewById(R.id.textView3);
//        String strA = edtA.getText().toString();
//        String strB = edtB.getText().toString();
//        double a = strA.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strA);
//        double b = strB.trim().equalsIgnoreCase("") ? 0 : Double.parseDouble(strB);
//        String ope = opr.getSelectedItem().toString();
//        if (ope.charAt(0) == '+') tv.setText("" + (a + b));
//        if (ope.charAt(0) == '-') tv.setText("" + (a - b));
//        if (ope.charAt(0) == '*') tv.setText("" + (a * b));
//        if (ope.charAt(0) == '/') tv.setText("" + (a / b));
//    }


    private Button.OnClickListener btnRollDiceOnClickLis2 = new Button.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, EditActivity.class);
            //.putExtra("name", edtName.getText().toString());
            startActivity(i);
        }
    };


    //button3按键监听
    private Button.OnClickListener btnRollDiceOnClickLis = new Button.OnClickListener() {
        public void onClick(View v) {
            Intent j = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(j);
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        // 取得偏好設定資料
        //String amount = prefs.getString(PREF_AMOUNT, "10000");
      //  txtAmount.setText(amount);
        //float rate = prefs.getFloat(PREF_RATE, 31.5F);
        //txtRate.setText(String.valueOf(rate));
    }
    @Override
    protected void onPause() {
        super.onPause();
        // 取得Editor物件
        SharedPreferences.Editor prefEdit = prefs.edit();
        // 存入偏好設定資料至Editor物件
        //prefEdit.putString(ww);
      //  float rate;
      //  rate = (float) Double.parseDouble(txtRate.getText().toString());
        //        //.putFloat(PREF_RATE, rate);
        prefEdit.apply(); // 寫入檔案
    }

}

