package cn.udday.simpleweather.utils;

import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.HourlyBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.Beans.NowBean;
import retrofit2.Call;

public interface HttpBackListenter {
    void onSuccess(NowBean nowBean, ForecastBean forecastBean, LifeBean lifeBean, HourlyBean hourlyBean);
     void onError(Call call, Throwable t);
}
