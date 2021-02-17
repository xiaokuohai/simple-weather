package cn.udday.simpleweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context,"weatherbasedate.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table date(_id integer primary key autoincrement,city varchar(20) unique not null,nowContent text,hourlyContent text,forecastContent text,lifeContent text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
