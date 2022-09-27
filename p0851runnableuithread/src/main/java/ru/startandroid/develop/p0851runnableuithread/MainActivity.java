package ru.startandroid.develop.p0851runnableuithread;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        Thread t =
                new Thread(
                        () -> {
                            try {
                                TimeUnit.SECONDS.sleep(2);
                                runOnUiThread(runn1);
                                TimeUnit.SECONDS.sleep(1);
                                tvInfo.postDelayed(runn3, 2000);
                                tvInfo.post(runn2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        t.start();
    }

    Runnable runn1 =
            new Runnable() {
                public void run() {
                    tvInfo.setText("runn1");
                }
            };

    Runnable runn2 =
            new Runnable() {
                public void run() {
                    tvInfo.setText("runn2");
                }
            };

    Runnable runn3 =
            new Runnable() {
                public void run() {
                    tvInfo.setText("runn3");
                }
            };
}
