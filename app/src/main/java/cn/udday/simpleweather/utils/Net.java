package cn.udday.simpleweather.utils;

import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.HourlyBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.Beans.NowBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Net {
    NowBean nowBean;
    HourlyBean hourlyBean;
    LifeBean lifeBean;
    ForecastBean forecastBean;
    //套娃回调
    public Net(String city,HttpBackListenter backListenter){
        WApi wApi = RetrofitImpl.getRetrofit().create(WApi.class);
        wApi.postNowJson(city).enqueue(new Callback<NowBean>() {
            @Override
            public void onResponse(Call<NowBean> call, Response<NowBean> nowResponse) {
                nowBean = nowResponse.body();
                wApi.postForecastJson(city).enqueue(new Callback<ForecastBean>() {
                    @Override
                    public void onResponse(Call<ForecastBean> call, Response<ForecastBean> forecastSponse) {
                        forecastBean = forecastSponse.body();
                        wApi.postLifeJson(city).enqueue(new Callback<LifeBean>() {
                            @Override
                            public void onResponse(Call<LifeBean> call, Response<LifeBean> lifeResponse) {
                                lifeBean = lifeResponse.body();
                                wApi.postHourlyJson(city).enqueue(new Callback<HourlyBean>() {
                                    @Override
                                    public void onResponse(Call<HourlyBean> call, Response<HourlyBean> hourlyResponse) {
                                        hourlyBean = hourlyResponse.body();
                                        System.out.println(hourlyResponse);
                                        backListenter.onSuccess(nowBean,forecastBean,lifeBean,hourlyBean);
                                    }

                                    @Override
                                    public void onFailure(Call<HourlyBean> call, Throwable t) {
                                        backListenter.onError(call,t);

                                    }
                                });
                            }

                            @Override
                            public void onFailure(Call<LifeBean> call, Throwable t) {
                                backListenter.onError(call,t);
                            }
                        });
                    }
                    @Override
                    public void onFailure(Call<ForecastBean> call, Throwable t) {
                        backListenter.onError(call,t);
                    }
                });
            }

            @Override
            public void onFailure(Call<NowBean> call, Throwable t) {
                //String s = t.getCause().toString();
                //Log.i ("kuohai",((MyThrowable)t).getMsg());
                backListenter.onError(call,t);

            }
        });
    }

}

