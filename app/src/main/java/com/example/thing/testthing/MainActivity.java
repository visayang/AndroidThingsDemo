package com.example.thing.testthing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Skeleton of an Android Things activity.
 * <p>
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 * <p>
 * <pre>{@code
 * PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 */
public class MainActivity extends Activity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.button:
                Toast.makeText(this, "我是", Toast.LENGTH_SHORT).show();

                OkHttpClient client = new OkHttpClient();
//创建Request,URLS是get方式拼接的地址
                Request request = new Request.Builder().url("http://api.k780.com:88/?app=ip.get&ip=8.8.8.8&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json").build();
//new call
                Call call = client.newCall(request);
//请求加入调度，onResponse方法不是UI线程注意
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
//获得字符串
                        final String json = response.body().string();
                        Log.i("123", json);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                btn.setText(json);
                            }
                        });
                    }
                });
                break;
            case R.id.button2:
                startActivity(new Intent(this,SecondActivity.class));
                break;

        }
//



    }
}
