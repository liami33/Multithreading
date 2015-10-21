package com.example.lian.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by Lian on 22/10/2015.
 */
public class Ping extends Thread {
    public static Handler handler;

    @Override
    public void run(){
        Looper.prepare();
        handler = new Handler() {
            @Override
            public void handleMessage(Message inMsg) {
                // accept incoming message
                Log.i("Cacific", (String) inMsg.obj);
                SystemClock.sleep(MainActivity.WAIT_TIME);

                // send out message
                Message outMsg = Message.obtain();
                outMsg.obj = "Hello from Ping.";
                if (Pong.handler != null)
                    Pong.handler.sendMessage(outMsg);
            }
        };
        Looper.loop();
    }
}
