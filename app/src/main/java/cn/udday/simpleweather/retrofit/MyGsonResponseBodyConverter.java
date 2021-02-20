package cn.udday.simpleweather.retrofit;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import cn.udday.simpleweather.Beans.BaseBean;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody,T> {
    private final Gson gson;
    private final Type type;

    public MyGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            BaseBean baseBean = gson.fromJson(response, BaseBean.class);
            if (baseBean.getCode() == 200) {
                return gson.fromJson(response, type);
            } else {
                Log.d("HttpManager", "err==：" + response);
                Log.d("HttpManager", "err==：" + baseBean.getCode());
                throw new MyThrowable(baseBean.getCode(),baseBean.getMsg());

            }
        } finally {
            value.close();
        }
        }
    }
