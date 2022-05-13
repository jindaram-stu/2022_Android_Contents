package com.daelim;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    LogThread myThread;
    static boolean flag;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class LogThread extends Thread {
        boolean flag = true;

        public void setFlag(boolean a) {
            flag = a;
        }
        @Override
        public void run() {
            while (flag) {
                Log.d("[MusicService]", "Play Song~");
                try {
                    Thread.sleep(2000);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onCreate() {

    }

    public void onDestroy() {
        System.out.println("dd");
        Toast.makeText(this,"MusicServic가 중지되었습니다.", Toast.LENGTH_SHORT).show();
        myThread.setFlag(false);

    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        myThread = new LogThread();
        Toast.makeText(this,"MusicServic가 시작되었습니다.", Toast.LENGTH_SHORT).show();
        myThread.setFlag(true);
        myThread.start();
        return super.onStartCommand(intent,flags,startId);
    }
}
