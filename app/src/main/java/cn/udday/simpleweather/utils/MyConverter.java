package cn.udday.simpleweather.utils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import cn.udday.simpleweather.Beans.BaseBean;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class MyConverter<T> implements Converter<ResponseBody,T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    public MyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        BaseBean baseResponse = gson.fromJson(response, BaseBean.class);
        if (baseResponse.getCode() != 200) {
            value.close();
            throw new MyThrowable(baseResponse.getMsg());
        }
        try {
            return adapter.fromJson(response);
        } finally {
            value.close();
        }
    }
}
