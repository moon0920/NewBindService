package com.example.edu.newbindservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private MyService myMusic;
    Button sBtnPlay, sBtnStop;
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName Name, IBinder binder) {
            myMusic = ((MyService.MyBinder)binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName MyService) {myMusic = null;}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = new Intent(this, MyService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);

        sBtnPlay = findViewById(R.id.sBtnPlay);
        sBtnPlay.setOnClickListener(this);
        sBtnStop = findViewById(R.id.sBtnStop);
        sBtnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sBtnPlay:
                myMusic.play();
//                sBtnPlay.setEnabled(false);
//                sBtnStop.setEnabled(true);
                break;
            case R.id.sBtnStop:
                myMusic.stop();
                break;

        }

    }
}
