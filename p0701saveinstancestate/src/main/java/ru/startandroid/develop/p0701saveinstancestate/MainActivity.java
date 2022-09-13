package ru.startandroid.develop.p0701saveinstancestate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    int cnt = 0;
    Object myObj = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cnt = savedInstanceState.getInt("count");
        Log.d(LOG_TAG, "onRestoreInstanceState");
    }

    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume ");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", cnt);
        Log.d(LOG_TAG, "onSaveInstanceState");
    }

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    public void onclick(View v) {
        Toast.makeText(this, "Count = " + ++cnt, Toast.LENGTH_SHORT).show();
    }

}
