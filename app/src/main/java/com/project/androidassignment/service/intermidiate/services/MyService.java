package com.project.androidassignment.service.intermidiate.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.project.androidassignment.R;
public class MyService extends Service {
    private MediaPlayer player;
    @Override
    public void onCreate() {
        super.onCreate();

        player = MediaPlayer.create(this, R.raw.cartoon);
        player.setVolume(100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();

        Log.d("here", "here");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
