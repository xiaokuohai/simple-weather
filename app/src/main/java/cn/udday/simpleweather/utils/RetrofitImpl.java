package cn.udday.simpleweather.utils;

import android.util.Log;

import cn.udday.simpleweather.retrofit.MyConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class RetrofitImpl {

    private static RetrofitImpl sInstance = new RetrofitImpl();
    private Retrofit mRetrofit;

    public static RetrofitImpl getInstance() {
        return sInstance;
    }

    public static Retrofit getRetrofit() {
        return sInstance.mRetrofit;
    }

    private RetrofitImpl() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("Http", message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(MyConverterFactory.create())
                .baseUrl(Constants.URL)
                .build();
    }
}
