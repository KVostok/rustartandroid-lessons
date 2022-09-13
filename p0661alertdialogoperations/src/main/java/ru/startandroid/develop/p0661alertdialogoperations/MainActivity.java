package ru.startandroid.develop.p0661alertdialogoperations;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    final int DIALOG = 1;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG) {
            Log.d(LOG_TAG, "Create");
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Title");
            adb.setMessage("Message");
            adb.setPositiveButton("OK", null);
            dialog = adb.create();

            // обработчик отображения
            dialog.setOnShowListener(dialog -> Log.d(LOG_TAG, "Show"));

            // обработчик отмены
            dialog.setOnCancelListener(dialog -> Log.d(LOG_TAG, "Cancel"));

            // обработчик закрытия
            dialog.setOnDismissListener(dialog -> Log.d(LOG_TAG, "Dismiss"));
            return dialog;
        }
        return super.onCreateDialog(id);
    }

//    void method1() {
//        dialog.dismiss();
//    }

//    void method1() {
//        dialog.cancel();
//    }

//    void method1() {
//        dialog.hide();
//    }

//    void method1() {
//        dismissDialog(DIALOG);
//    }

    void method1() {
        removeDialog(DIALOG);
    }

    void method2() {
        showDialog(DIALOG);
    }

    public void onclick(View v) {
        showDialog(DIALOG);
        Handler h = new Handler();
        h.postDelayed(() -> method1(), 2000);
        h.postDelayed(() -> method2(), 4000);
    }
}
