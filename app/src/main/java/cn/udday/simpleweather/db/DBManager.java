package cn.udday.simpleweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import cn.udday.simpleweather.Beans.AllBean;
import cn.udday.simpleweather.Beans.BaseBean;
import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.HourlyBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.Beans.NowBean;
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
    //存储城市天气最多5个
    public static int getCityCount(){
        Cursor date = database.query("date", null, null, null, null, null, null);
        int count = date.getCount();
        return count;
    }
    //查询数据库中的全部信息
    public static List<AllBean> queryAllDate(){
        Cursor date = database.query("date",null, null, null, null, null, null);
        List<AllBean> list = new ArrayList<>();
        while(date.moveToNext()){
            int id = date.getInt(date.getColumnIndex("_id"));
            String city = date.getString(date.getColumnIndex("city"));
            String nowString = date.getString(date.getColumnIndex(Constants.DATE_NOW));
            String forecastString = date.getString(date.getColumnIndex(Constants.DATE_FORECAST));
            String lifeString = date.getString(date.getColumnIndex(Constants.DATE_LIFE));
            String hourlyString = date.getString(date.getColumnIndex(Constants.DATE_HOURLY));
            Gson gson = new Gson();
            NowBean nowBean = gson.fromJson(nowString, NowBean.class);
            ForecastBean forecastBean = gson.fromJson(forecastString, ForecastBean.class);
            LifeBean lifeBean = gson.fromJson(lifeString, LifeBean.class);
            HourlyBean hourlyBean = gson.fromJson(hourlyString, HourlyBean.class);
            AllBean allBean = new AllBean(id, city, nowBean, forecastBean, lifeBean, hourlyBean);
            list.add(allBean);
        }
        return list;
    }
    //查询单个的数据
    public static AllBean queryOneDateByCity(String city){
        Cursor date = database.query("date",null, "city=?", new String[]{city}, null, null, null);
        if (date.getCount() > 0) {
            date.moveToFirst();
            int id = date.getInt(date.getColumnIndex("_id"));
            String city1 = date.getString(date.getColumnIndex("city"));
            String nowString = date.getString(date.getColumnIndex(Constants.DATE_NOW));
            String forecastString = date.getString(date.getColumnIndex(Constants.DATE_FORECAST));
            String lifeString = date.getString(date.getColumnIndex(Constants.DATE_LIFE));
            String hourlyString = date.getString(date.getColumnIndex(Constants.DATE_HOURLY));
            Gson gson = new Gson();
            NowBean nowBean = gson.fromJson(nowString, NowBean.class);
            ForecastBean forecastBean = gson.fromJson(forecastString, ForecastBean.class);
            LifeBean lifeBean = gson.fromJson(lifeString, LifeBean.class);
            HourlyBean hourlyBean = gson.fromJson(hourlyString, HourlyBean.class);
            AllBean allBean = new AllBean(id, city1, nowBean, forecastBean, lifeBean, hourlyBean);
            return allBean;
        }
        return null;
    }
    //根据城市名称删除这个城市在数据库中的数据
    public static int deleteDateByCity(String city){
        return database.delete("date","city=?",new String[]{city});

    }
    //删除表中所有信息
    public static void deleteAllDate(){
        String sql = "delete from date";
        database.execSQL(sql);
    }
}
