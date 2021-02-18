package cn.udday.simpleweather.base;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.HourlyBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.utils.HttpBackListenter;
import cn.udday.simpleweather.utils.MyThrowable;
import cn.udday.simpleweather.utils.RetrofitImpl;
import cn.udday.simpleweather.utils.WApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseActivity extends AppCompatActivity{
    public void loadDate(String city, HttpBackListenter backListenter){
        WApi wApi = RetrofitImpl.getRetrofit().create(WApi.class);
        wApi.postNowJson(city).enqueue(new Callback<NowBean>() {
            @Override
            public void onResponse(Call<NowBean> call, Response<NowBean> nowResponse) {
                wApi.postForecastJson(city).enqueue(new Callback<ForecastBean>() {
                    @Override
                    public void onResponse(Call<ForecastBean> call, Response<ForecastBean> forecastSponse) {
                        wApi.postLifeJson(city).enqueue(new Callback<LifeBean>() {
                            @Override
                            public void onResponse(Call<LifeBean> call, Response<LifeBean> lifeResponse) {
                                wApi.postHourlyJson(city).enqueue(new Callback<HourlyBean>() {
                                    @Override
                                    public void onResponse(Call<HourlyBean> call, Response<HourlyBean> hourlyResponse) {
                                        backListenter.onSuccess(nowResponse.body(),forecastSponse.body(),lifeResponse.body(),hourlyResponse.body());
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

