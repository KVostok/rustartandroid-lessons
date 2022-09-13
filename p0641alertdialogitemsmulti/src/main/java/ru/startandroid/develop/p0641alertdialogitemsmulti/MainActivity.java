package ru.startandroid.develop.p0641alertdialogitemsmulti;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    final int DIALOG_ITEMS = 1;
    final int DIALOG_CURSOR = 3;
    DB db;
    Cursor cursor;

    String data[] = {"one", "two", "three", "four"};
    boolean chkd[] = {false, true, true, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // открываем подключение к БД
        db = new DB(this);
        db.open();
        cursor = db.getAllData();
        startManagingCursor(cursor);
    }

    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.btnItems:
                showDialog(DIALOG_ITEMS);
                break;
            case R.id.btnCursor:
                showDialog(DIALOG_CURSOR);
                break;
            default:
                break;
        }
    }

    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        switch (id) {
                // массив
            case DIALOG_ITEMS:
                adb.setTitle(R.string.items);
                adb.setMultiChoiceItems(data, chkd, myItemsMultiClickListener);
                break;
                // курсор
            case DIALOG_CURSOR:
                adb.setTitle(R.string.cursor);
                adb.setMultiChoiceItems(
                        cursor, DB.COLUMN_CHK, DB.COLUMN_TXT, myCursorMultiClickListener);
                break;
        }
        adb.setPositiveButton(R.string.ok, myBtnClickListener);
        return adb.create();
    }

    // обработчик для списка массива
    DialogInterface.OnMultiChoiceClickListener myItemsMultiClickListener =
            new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    Log.d(LOG_TAG, "which = " + which + ", isChecked = " + isChecked);
                }
            };

    // обработчик для списка курсора
    DialogInterface.OnMultiChoiceClickListener myCursorMultiClickListener =
            new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    ListView lv = ((AlertDialog) dialog).getListView();
                    Log.d(LOG_TAG, "which = " + which + ", isChecked = " + isChecked);
                    db.changeRec(which, isChecked);
                    cursor.requery();
                }
            };

    // обработчик нажатия на кнопку
    DialogInterface.OnClickListener myBtnClickListener =
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    SparseBooleanArray sbArray =
                            ((AlertDialog) dialog).getListView().getCheckedItemPositions();
                    for (int i = 0; i < sbArray.size(); i++) {
                        int key = sbArray.keyAt(i);
                        if (sbArray.get(key)) Log.d("qwe", "checked: " + key);
                    }
                }
            };

    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
