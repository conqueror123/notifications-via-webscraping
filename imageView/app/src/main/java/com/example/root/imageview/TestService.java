package com.example.root.imageview;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import java.util.Timer;
import java.util.TimerTask;

public class TestService extends Service {
    private static Timer timer ;
    private static TimerTask timerTask;
    int counter=0;

    public TestService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        con.setIsNotification_enabled(true);
        startingtimer();

        return START_STICKY;
    }

    private void notice(int i) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_art_track_black_24dp).setContentTitle(con.getNotificationTitle() +i).setContentText(con.getNotificationBody());
        Intent notificationIntent = new Intent(this,Notification.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }

    public void startingtimer(){
        timer = new Timer();
        initialiseTimerTask();
        timer.schedule(timerTask,1000,1000);
    }

    private void initialiseTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                webB.scrape();
                if (con.isIsNotification_enabled()) {
                    if (con.getNotificationTitle().isEmpty() || con.empty_Notification.equals(con.getNotificationTitle())){
                        con.setIsNotification_enabled(false);
                    }
                    else {
                        counter++;
                        notice(counter);
                        con.setIsNotification_enabled(false);
                    }
                }
            }
        };
    }
    @Override
    public void onDestroy(){
        timer.cancel();
        super.onDestroy();
    }
}
