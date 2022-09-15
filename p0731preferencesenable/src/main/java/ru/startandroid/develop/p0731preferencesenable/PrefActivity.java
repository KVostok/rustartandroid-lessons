package ru.startandroid.develop.p0731preferencesenable;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PrefActivity extends PreferenceActivity {

    CheckBoxPreference chb3;
    PreferenceCategory categ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);

        chb3 = (CheckBoxPreference) findPreference("chb3");
        categ2  = (PreferenceCategory) findPreference("categ2");
        categ2.setEnabled(chb3.isChecked());

        chb3.setOnPreferenceClickListener(preference -> {
            categ2.setEnabled(chb3.isChecked());
            return false;
        });
    }
}