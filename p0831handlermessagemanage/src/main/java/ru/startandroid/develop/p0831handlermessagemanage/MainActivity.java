package ru.startandroid.develop.p0831handlermessagemanage;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    Handler h;

    Handler.Callback hc = msg -> {
        Log.d(LOG_TAG, "what = " + msg.what);
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = new Handler(hc);
        sendMessages();
    }

    void sendMessages() {
        Log.d(LOG_TAG, "send messages");
        h.sendEmptyMessageDelayed(1, 1000);
        h.sendEmptyMessageDelayed(2, 2000);
        h.sendEmptyMessageDelayed(3, 3000);
        h.sendEmptyMessageDelayed(2, 4000);
        h.sendEmptyMessageDelayed(5, 5000);
        h.sendEmptyMessageDelayed(2, 6000);
        h.sendEmptyMessageDelayed(7, 7000);
        h.removeMessages(2);
    }
}