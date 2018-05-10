package com.example.tohsaka.myapplication3;
//Author:TOOSAKA
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

    //加速度计、陀螺仪、姿态角的数据
    public static int VAL_ACC_X = 0;
    public static int VAL_ACC_Y = 0;
    public static int VAL_ACC_Z = 0;
    public static int VAL_GYR_X = 0;
    public static int VAL_GYR_Y = 0;
    public static int VAL_GYR_Z = 0;
    public static float VAL_ANG_X = 0;
    public static float VAL_ANG_Y = 0;
    public static float VAL_ANG_Z = 0;


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



    //字符串数据发送函数
    static void SendData(String message){
        //确认蓝牙设备是否已连接
        if(mRfcommClient.getState()!= BluetoothRfcommClient.STATE_CONNECTED){
            //Toast.makeText(this,"未连接到蓝牙设备", Toast.LENGTH_SHORT).show();
            return;
        }

        if(message.length() >0 ){
            byte[] send = message.getBytes();
            mRfcommClient.write(send);
        }
    }


    //字符数据发送函数
    static void SendData_Byte(byte[] data){
        if(mRfcommClient.getState() != BluetoothRfcommClient.STATE_CONNECTED)
            return;

        mRfcommClient.write(data);
    }


    //控制命令发送函数
    static void Send_Command(byte data){
        byte[] bytes = new byte[6];
        byte sum = 0;

        if(mRfcommClient.getState() != BluetoothRfcommClient.STATE_CONNECTED)
            return;

        bytes[0] = (byte)0xaa;
        bytes[1] = (byte)0xaf;
        bytes[2] = (byte)0x01;
        bytes[3] = (byte)0x01;
        bytes[4] = (byte)data;

        for(int i=0; i<5; i++)
            sum += bytes[i];

        bytes[5] = sum;
        SendData_Byte(bytes);

    }
    static int Buffer_Length = 1000;
    static byte[] Read = new byte[Buffer_Length];
    static int ReadLength = 0;//读取的数据长度
    static int ReadState = 0;//读取数据的状态
    static int ReadCount = 0;//计数


    //数据接收处理函数
    static void DataAnl(byte[] data, int length){
        for(int i=0; i<length; i++){


            //读第一个AA
            if(ReadState == 0){
                if(data[i] == (byte)0xaa){
                    ReadState = 1;
                    Read[0] = (byte)0xaa;
                }
            }

            //读第二个AA
            else if(ReadState == 1){
                if(data[i] == (byte)0xaa){
                    ReadState = 2;
                    Read[1] = (byte)0xaa;
                }
                else
                    ReadState = 0;
            }


            else if(ReadState == 2){
                ReadState = 3;
                Read[2] = data[i];
            }

            else if(ReadState == 3){
                if(data[i] > 45)
                    ReadState = 0;
                else{
                    ReadState = 4;
                    Read[3] = data[i];
                    ReadLength = data[i];
                    if(ReadLength < 0)
                        ReadLength = -ReadLength;
                    ReadCount = 4;
                }
            }

            else if(ReadState == 4){
                ReadLength--;
                Read[ReadCount] = data[i];
                ReadCount++;
                if(ReadLength <= 0)
                    ReadState = 5;

            }

            else if(ReadState == 5){
                Read[ReadCount] = data[i];
                if(ReadCount <= (Buffer_Length-1))
                    FrameAnl(ReadCount+1);
                ReadState = 0;


            }
        }
    }


    static void FrameAnl(int length){
        byte sum = 0;
        for(int i=0; i<(length-1); i++)
            sum += Read[i];
        if(sum==Read[length-1])//两个总和值相等
        {

            if(Read[2]==1)//返回的是加计
            {
                VAL_ANG_X = ((float)(BytetoUint(4)))/100;
                VAL_ANG_Y = ((float)(BytetoUint(6)))/100;
                VAL_ANG_Z = ((float)(BytetoUint(8)))/100;
            }
            if(Read[2]==2)//返回的有加计和陀螺仪
            {
                VAL_ACC_X = BytetoUint(4);
                VAL_ACC_Y = BytetoUint(6);
                VAL_ACC_Z = BytetoUint(8);
                VAL_GYR_X = BytetoUint(10);
                VAL_GYR_Y = BytetoUint(12);
                VAL_GYR_Z = BytetoUint(14);
            }

        }
    }

    static short BytetoUint(int count)
    {
        short r = 0;
        r <<= 8;  //r左移8位
        r |= (Read[count] & 0x00ff);
        r <<= 8;
        r |= (Read[count+1] & 0x00ff);
        return r;
    }
}

