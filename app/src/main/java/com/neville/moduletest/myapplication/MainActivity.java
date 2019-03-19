package com.neville.moduletest.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("i", "onCreate");
        findViewById(R.id.tv_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //    设置Title的图标
                builder.setIcon(R.drawable.ic_launcher_background);
                //    设置Title的内容
                builder.setTitle("弹出警告框");
                //    设置Content来显示一个信息
                builder.setMessage("确定删除吗？");
                //    设置一个PositiveButton
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                //    设置一个NegativeButton
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("i", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("i", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("i", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("i", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("i", "onDestroy");

    }
}
