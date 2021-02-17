package cn.udday.simpleweather.utils;
import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.NowBean;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WApi {
    @Headers("token:a337xZZFXIn7SqD1")
    @POST("now")
    Call<NowBean> postNowJson(@Query("location") String location);
    @Headers("token:a337xZZFXIn7SqD1")
    @POST("forecast")
    Call<ForecastBean> postForecastJson(@Query("location") String location);
}
