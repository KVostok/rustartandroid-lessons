package ru.startandroid.develop.p0711preferencessimple;

import android.preference.PreferenceActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }
}