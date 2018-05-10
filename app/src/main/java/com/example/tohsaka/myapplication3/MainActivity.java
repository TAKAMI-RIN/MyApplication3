package com.example.tohsaka.myapplication3;
//Author:TOOSAKA
//20180413:5
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog.Builder;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;






public class MainActivity extends AppCompatActivity {
    private Button Button3;
    private Button Button2;
    private SharedPreferences prefs;
    public char ww = 1;
    public static final int MESSAGE_STATIC_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME =4;
    public static final int MESSAGE_TOAST = 5;

    //获取设备名字
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    //请求使用蓝牙设备
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;

    //与蓝牙相关的变量
    private String mConnectedDeviceName = null;
    private BluetoothAdapter mBluetoothAdapter = null;
    private static BluetoothRfcommClient  mRfcommClient = null;

    private TextView mStatus;//显示蓝牙连接状态
    //int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs =	getPreferences(MODE_PRIVATE);
        //显示蓝牙状态
        mStatus = (TextView) findViewById(R.id.message);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Button3 = (Button)findViewById(R.id.button3);
        Button3.setOnClickListener(btnRollDiceOnClickLis);
        Button2 = (Button)findViewById(R.id.button2);
        Button2.setOnClickListener(btnRollDiceOnClickLis2);

        //请求打开蓝牙
        if(!mBluetoothAdapter.isEnabled()){
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        }

//        mRfcommClient = new BluetoothRfcommClient(this,mHandler);

//        ImageButton mImageButton = (ImageButton) findViewById(R.id.bluetooth);
//        mImageButton.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, MyBluetooth.class);
//
//                //返回蓝牙匹配信息
//                startActivityForResult(intent, REQUEST_CONNECT_DEVICE);
//
//            }
//        });
//
//
//
//        mImageButton = (ImageButton) findViewById(R.id.control);
//        mImageButton.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //用显式Intent打开飞行控制界面
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, TsControl.class);
//                startActivity(intent);
//
//            }
//        });

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


    //退出提醒
    @Override
    public void onBackPressed(){
        Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("TOOSAKA")
                .setMessage("close the BLT?");

        mBuilder.setPositiveButton("sure", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        mBuilder.setNegativeButton("shit", null).show();
    }


    public static void DataAnl(byte[] buffer, int bytes) {
    }
}

