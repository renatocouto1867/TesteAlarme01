package com.example.testealarme01;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmUtil {
    public static void adicionarAlarm(Context c, long time){
        AlarmManager alarmManeger = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = criarPendinIntent(c);
        alarmManeger.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, time,1*60*1000,pendingIntent);//1*60*1000 um minuto
    }

    private static PendingIntent criarPendinIntent(Context c){
        Intent intent = new Intent(c, AlarmeReceiver.class);
        return PendingIntent.getBroadcast(c,0,intent,PendingIntent.FLAG_IMMUTABLE);
    }//

    public static void cancelarAlarm(Context c){
        AlarmManager alarmManeger = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = criarPendinIntent(c);
        alarmManeger.cancel(pendingIntent);
    }
}//Class
