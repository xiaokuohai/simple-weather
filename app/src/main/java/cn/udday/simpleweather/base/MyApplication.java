package cn.udday.simpleweather.base;

import android.app.Application;

import cn.udday.simpleweather.db.DBManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBManager.initDB(this);
    }
}

