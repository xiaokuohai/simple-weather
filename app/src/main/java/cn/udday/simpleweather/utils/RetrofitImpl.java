package cn.udday.simpleweather.utils;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                Log.d("net", message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ContextString.URL)
                .build();
    }
}
