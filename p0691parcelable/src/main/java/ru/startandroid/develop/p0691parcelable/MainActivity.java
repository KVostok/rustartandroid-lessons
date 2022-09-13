package ru.startandroid.develop.p0691parcelable;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        MyObject myObj = new MyObject("text", 1);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MyObject.class.getCanonicalName(), myObj);
        Log.d(LOG_TAG, "startActivity");
        startActivity(intent);
    }
}