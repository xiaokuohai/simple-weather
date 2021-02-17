package cn.udday.simpleweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    public static SQLiteDatabase database;
    //初始化
    public static void initDB(Context context){
        DBHelper dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }
}
