package ru.startandroid.develop.p0551headerfooter;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    String[] data = {"one", "two", "three", "four", "five"};
    ListView lvMain;
    ArrayAdapter<String> adapter;

    View header1;
    View header2;

    View footer1;
    View footer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        // создаем Header и Footer
        header1 = createHeader("header 1");
        header2 = createHeader("header 2");
        footer1 = createFooter("footer 1");
        footer2 = createFooter("footer 2");

        fillList();
    }

    // формирование списка
    void fillList() {
        lvMain.addHeaderView(header1);
        lvMain.addHeaderView(header2, "some text for header 2", false);
        lvMain.addFooterView(footer1);
        lvMain.addFooterView(footer2, "some text for footer 2", false);
        lvMain.setAdapter(adapter);
    }

    // нажатие кнопки
//    public void onclick(View v) {
//        lvMain.removeHeaderView(header2);
//        lvMain.removeFooterView(footer2);
//    }

    // нажатие кнопки
    public void onclick(View v) {
        Object obj;
        HeaderViewListAdapter hvlAdapter = (HeaderViewListAdapter) lvMain.getAdapter();
        obj = hvlAdapter.getItem(1);
        Log.d(LOG_TAG, "hvlAdapter.getItem(1) = " + obj.toString());
        obj = hvlAdapter.getItem(4);
        Log.d(LOG_TAG, "hvlAdapter.getItem(4) = " + obj.toString());

        ArrayAdapter<String> alAdapter = (ArrayAdapter<String>) hvlAdapter.getWrappedAdapter();
        obj = alAdapter.getItem(1);
        Log.d(LOG_TAG, "alAdapter.getItem(1) = " + obj.toString());
        obj = alAdapter.getItem(4);
        Log.d(LOG_TAG, "alAdapter.getItem(4) = " + obj.toString());
    }

    // создание Header
    View createHeader(String text) {
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView)v.findViewById(R.id.tvText)).setText(text);
        return v;
    }

    // создание Footer
    View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView)v.findViewById(R.id.tvText)).setText(text);
        return v;
    }
}