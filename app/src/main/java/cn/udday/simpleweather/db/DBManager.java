package cn.udday.simpleweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.udday.simpleweather.utils.Constants;

public class DBManager {
    public static SQLiteDatabase database;
    //初始化
    public static void initDB(Context context){
        DBHelper dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }
    //查找数据库中的城市列表
    public static ArrayList<String> queryAllCityName(){
        Cursor date = database.query("date", null,null,null, null, null, null);
        ArrayList<String> cityList = new ArrayList<>();
        while (date.moveToNext()) {
            String city = date.getString(date.getColumnIndex("city"));
            cityList.add(city);
        }
        return cityList;
    }
    //插入or更新
    public static int upDateDateByCity(String city,String content,String type){
        ContentValues values = new ContentValues();
        switch (type){
            case Constants.DATE_NOW:
                values.put(Constants.DATE_NOW,content);
                break;
            case Constants.DATE_FORECAST:
                values.put(Constants.DATE_FORECAST,content);
                break;
            case Constants.DATE_LIFE:
                values.put(Constants.DATE_LIFE,content);
                break;
            case Constants.DATE_HOURLY:
                values.put(Constants.DATE_HOURLY,content);
                break;
        }
        return database.update("date",values,"city=?",new String[]{city});
    }
    //新增一条城市信息
    public static long addCityDate(String city,String content,String type){
        ContentValues values = new ContentValues();
        values.put("city",city);
        switch (type){
            case Constants.DATE_NOW:
                values.put(Constants.DATE_NOW,content);
                break;
            case Constants.DATE_FORECAST:
                values.put(Constants.DATE_FORECAST,content);
                break;
            case Constants.DATE_LIFE:
                values.put(Constants.DATE_LIFE,content);
                break;
            case Constants.DATE_HOURLY:
                values.put(Constants.DATE_HOURLY,content);
                break;
        }
        return database.insert("date",null,values);
    }
    //根据城市名查询数据库当中内容
    public static String queryDateByCity(String city,String type){
        Cursor date = database.query("date", null, "city=?", new String[]{city}, null, null, null);
        if (date.getCount() > 0) {
            date.moveToFirst();
            return date.getString(date.getColumnIndex(type));
        }
        return null;
    }
}
