package ru.startandroid.develop.p0681parcel;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    Parcel p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeParcel();
        readParcel();
    }

    void writeParcel() {
        p = Parcel.obtain();

        byte b = 1;
        int i = 2;
        long l = 3;
        float f = 4;
        double d = 5;
        String s = "abcdefgh";

        logWriteInfo("before writing");
        p.writeByte(b);
        logWriteInfo("byte");
        p.writeInt(i);
        logWriteInfo("int");
        p.writeLong(l);
        logWriteInfo("long");
        p.writeFloat(f);
        logWriteInfo("float");
        p.writeDouble(d);
        logWriteInfo("double");
        p.writeString(s);
        logWriteInfo("String");
    }

    void logWriteInfo(String txt) {
        Log.d(LOG_TAG, txt + ": " + "dataSize = " + p.dataSize());
    }

    void readParcel() {
        logReadInfo("before reading");
        p.setDataPosition(0);
        logReadInfo("byte = " + p.readByte());
        logReadInfo("int = " + p.readInt());
        logReadInfo("long = " + p.readLong());
        logReadInfo("float = " + p.readFloat());
        logReadInfo("double = " + p.readDouble());
        logReadInfo("string = " + p.readString());
    }

    void logReadInfo(String txt) {
        Log.d(LOG_TAG, txt + ": " + "dataPosition = " + p.dataPosition());
    }
}
