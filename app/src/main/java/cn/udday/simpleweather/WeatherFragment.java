package cn.udday.simpleweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.utils.RetrofitImpl;
import cn.udday.simpleweather.utils.WApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherFragment extends Fragment implements View.OnClickListener{

    private LinearLayout mFragLayout;
    private TextView mFragTvNowtemp;
    private TextView mFragTvCity;
    private TextView mFragTvCondition;
    private TextView mFragTvDate;
    private TextView mFragTvWind;
    private TextView mFragTvPcpn;
    private ImageView mFragIvToday;
    private LinearLayout mFragCenterLayout;
    private LinearLayout mFragIndexLayout;
    private TextView mFragTvDress;
    private TextView mFragTvCar;
    private TextView mFragTvCold;
    private TextView mFragTvSport;
    private TextView mFragTvRays;
    private String city;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather,container,false);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        WApi wApi = RetrofitImpl.getRetrofit().create(WApi.class);
        wApi.postNowJson(city).enqueue(new Callback<NowBean>() {
            @Override
            public void onResponse(Call<NowBean> call, Response<NowBean> response) {
                NowBean nowBean = response.body();
                System.out.println(nowBean.toString());
            }

            @Override
            public void onFailure(Call<NowBean> call, Throwable t) {
                Toast.makeText(getContext(),"网络错误", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        //初始化
        mFragLayout = view.findViewById(R.id.frag_layout);
        mFragTvNowtemp = view.findViewById(R.id.frag_tv_nowtemp);
        mFragTvCity = view.findViewById(R.id.frag_tv_city);
        mFragTvCondition = view.findViewById(R.id.frag_tv_condition);
        mFragTvDate = view.findViewById(R.id.frag_tv_date);
        mFragTvWind = view.findViewById(R.id.frag_tv_wind);
        mFragTvPcpn = view.findViewById(R.id.frag_tv_pcpn);
        mFragIvToday = view.findViewById(R.id.frag_iv_today);
        mFragCenterLayout = view.findViewById(R.id.frag_center_layout);
        mFragIndexLayout = view.findViewById(R.id.frag_index_layout);
        mFragTvDress = view.findViewById(R.id.frag_tv_dress);
        mFragTvCar = view.findViewById(R.id.frag_tv_car);
        mFragTvCold = view.findViewById(R.id.frag_tv_cold);
        mFragTvSport = view.findViewById(R.id.frag_tv_sport);
        mFragTvRays = view.findViewById(R.id.frag_tv_rays);
        //设置点击事件
        mFragTvDress.setOnClickListener(this);
        mFragTvCar.setOnClickListener(this);
        mFragTvCold.setOnClickListener(this);
        mFragTvSport.setOnClickListener(this);
        mFragTvRays.setOnClickListener(this);
        //得到城市from MainActivity
        Bundle bundle = getArguments();
        city = bundle.getString("city");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frag_tv_dress:

                break;
            case R.id.frag_tv_car:

                break;
            case R.id.frag_tv_cold:

                break;
            case R.id.frag_tv_sport:

                break;
            case R.id.frag_tv_rays:

                break;
        }
    }
}
