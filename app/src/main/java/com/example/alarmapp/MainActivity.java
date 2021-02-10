package com.example.alarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private TimePicker timePicker;
    private TextClock textClock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textClock=findViewById(R.id.textClock);
        timePicker=findViewById(R.id.timePicker);
        Uri ringtoneUri;
        final Ringtone r=RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));


        Timer t=new Timer();

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(textClock.getText().toString().equals(AlarmTime())){
                        r.play();
                }else {
                    r.stop();
                }
            }
        },0,1000);






    }


  public String AlarmTime(){
        Integer alarmHour=timePicker.getCurrentHour();
        Integer alarmMiniute=timePicker.getCurrentMinute();

        String  stringAlarmTime;
        String stringAlarmMiniute;


        if(alarmMiniute<10){
            stringAlarmMiniute="0"+alarmMiniute.toString();
        }else{
            stringAlarmMiniute=alarmMiniute.toString();
        }

            if(alarmHour>12){
                alarmHour=alarmHour-12;
                stringAlarmTime=alarmHour.toString().concat(":").concat(stringAlarmMiniute).concat(" PM");
            }else{
                stringAlarmTime=alarmHour.toString().concat(":").concat(stringAlarmMiniute).concat(" AM");

            }


        return  stringAlarmTime;

  }






}