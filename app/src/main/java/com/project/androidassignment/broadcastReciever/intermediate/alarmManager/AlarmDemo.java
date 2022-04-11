package com.project.androidassignment.broadcastReciever.intermediate.alarmManager;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.project.androidassignment.databinding.ActivityAlarmDemoBinding;

import java.util.Calendar;

public class AlarmDemo extends AppCompatActivity {
    private ActivityAlarmDemoBinding binding;
    private Calendar calendar;
    private AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlarmDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createNotificationChannel();

        binding.setAlarmBtn.setOnClickListener(v -> {
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    // set alarm
                    calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                    calendar.set(Calendar.MINUTE, timePicker.getMinute());
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);

                    Intent intent = new Intent(AlarmDemo.this, AlarmReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmDemo.this, 0, intent, 0);

                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                    binding.alarmTV.setText(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(calendar.get(Calendar.MINUTE)));
                }
            }, 12, 00, false);

            dialog.create();
            dialog.show();
        });

        binding.cancelAlarmBtn.setOnClickListener(v -> {
            if(alarmManager != null){
                Intent intent = new Intent(AlarmDemo.this, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmDemo.this, 0, intent, 0);
                alarmManager.cancel(pendingIntent);
            }
        });
    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            String name = "alarmChannel";
            String des = "channel for alarm notification";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel("notificationChannelOne", name, importance);
            channel.setDescription(des);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
