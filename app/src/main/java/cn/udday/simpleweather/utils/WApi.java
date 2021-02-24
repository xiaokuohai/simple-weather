package cn.udday.simpleweather.utils;
import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.HourlyBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.Beans.NowBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WApi {
    @Headers("token:a337xZZFXIn7SqD1")
    @GET("now")
    Call<NowBean> getNowJson();
    @Headers("token:a337xZZFXIn7SqD1")
    @POST("now")
    Call<NowBean> postNowJson(@Query("location") String location);
    @Headers("token:a337xZZFXIn7SqD1")
    @POST("forecast")
    Call<ForecastBean> postForecastJson(@Query("location") String location);
    @Headers("token:a337xZZFXIn7SqD1")
    @POST("life")
    Call<LifeBean> postLifeJson(@Query("location") String location);
    @Headers("token:a337xZZFXIn7SqD1")
    @POST("hourly")
    Call<HourlyBean> postHourlyJson(@Query("location") String location);
}
