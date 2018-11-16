package com.example.edu.newbindservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;


public class MyService extends Service {
    public MyService(){

    }
    MediaPlayer mplayer;
    @Override
    public IBinder onBind(Intent arg0) { return new MyBinder();  }
        // TODO: Return the communication channel to the service.
    public class MyBinder extends Binder {
            MyService getService() {
                return MyService.this;
            }
        }
    public void play(){
        mplayer = MediaPlayer.create(this, R.raw.thunder_rain);
        mplayer.setLooping(true);
        mplayer.setVolume(200,1000);
        mplayer.start();

        }
    public void stop(){
        mplayer.stop();
        mplayer.release();

    }

}

