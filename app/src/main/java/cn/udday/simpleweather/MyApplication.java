package cn.udday.simpleweather;

import android.app.Application;

import cn.udday.simpleweather.db.DBManager;

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        DBManager.initDB(this);
    }
}
