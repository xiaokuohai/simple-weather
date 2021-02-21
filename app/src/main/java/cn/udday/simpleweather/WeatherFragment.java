package cn.udday.simpleweather;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.transition.MaterialContainerTransform;
import com.google.android.material.transition.MaterialFadeThrough;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.udday.simpleweather.Beans.AllBean;
import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.HourlyBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.adapter.FragmentForecastAdapter;
import cn.udday.simpleweather.db.DBManager;
import cn.udday.simpleweather.utils.Constants;
import cn.udday.simpleweather.utils.HttpBackListenter;
import cn.udday.simpleweather.utils.Net;
import cn.udday.simpleweather.utils.RetrofitImpl;
import cn.udday.simpleweather.utils.WApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class WeatherFragment extends Fragment implements View.OnClickListener{

    private ScrollView mFragSv;
    private LinearLayout mFragLayout;
    private TextView mFragTvNowtemp;
    private TextView mFragTvCity;
    private TextView mFragTvCondition;
    private TextView mFragTvDate;
    private TextView mFragTvWind;
    private TextView mFragTvPcpn;
    private LinearLayout mFragCenterLayout;
    private LinearLayout mFragHourlyLayout;
    private TextView mFragHourlyTv;
    private RecyclerView mFragFRv;
    private String city;
    private List<View> itemViewList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather,container,false);
        initView(view);
        setView(view);


        return view;
    }

    private void setView(View view) {
        mFragHourlyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //小时情况点击
                if (itemViewList != null) {
                    if (itemViewList.get(1).getVisibility() == View.GONE) {
                        for (int i = 0; i < itemViewList.size(); i++) {
                            View view1 = itemViewList.get(i);
                            view1.setVisibility(View.VISIBLE);
                        }
                        mFragHourlyTv.setVisibility(View.GONE);
                    } else {
                        for (int i = 0; i < itemViewList.size(); i++) {
                            View view1 = itemViewList.get(i);
                            view1.setVisibility(View.GONE);
                            mFragHourlyTv.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNet();
        new MaterialFadeThrough();
    }

    private void initNet() {
        //得到城市from MainActivity
        Bundle bundle = getArguments();
        city = bundle.getString("city");
        new Net(city, new HttpBackListenter() {
            @Override
            public void onSuccess(NowBean nowBean, ForecastBean forecastBean, LifeBean lifeBean, HourlyBean hourlyBean) {
                int t = DBManager.upDateDateByCity(city, nowBean.toString(), Constants.DATE_NOW);
                        DBManager.upDateDateByCity(city, forecastBean.toString(), Constants.DATE_FORECAST);
                        DBManager.upDateDateByCity(city, lifeBean.toString(), Constants.DATE_LIFE);
                        DBManager.upDateDateByCity(city, hourlyBean.toString(), Constants.DATE_HOURLY);
                    if (t <= 0) {
                        //更新数据库失败，及没有这个城市，就增加这条记录
                        DBManager.addCityDate(city, nowBean.toString(), Constants.DATE_NOW);
                        DBManager.upDateDateByCity(city, forecastBean.toString(), Constants.DATE_FORECAST);
                        DBManager.upDateDateByCity(city, lifeBean.toString(), Constants.DATE_LIFE);
                        DBManager.upDateDateByCity(city, hourlyBean.toString(), Constants.DATE_HOURLY);
                    }
                initDate();
            }

            @Override
            public void onError(Call call, Throwable t) {

            }
        });
    }

    private void initDate() {
        AllBean allBean = DBManager.queryOneDateByCity(city);
        putNowDate(allBean.getNowBean());
        putForecastDate(allBean.getForecastBean());
        putHourlyDate(allBean.getHourlyBean());
        putLifeDate(allBean.getLifeBean());
        changeBg(allBean.getNowBean());
    }

    private void changeBg(NowBean nowBean) {
        String state = nowBean.getData().getNow().getCond_txt();
        switch (state){
            case "晴":
                mFragSv.setBackgroundResource(R.mipmap.iq_qin);
                break;
            case "多云":
                mFragSv.setBackgroundResource(R.mipmap.iq_duoyun);
                break;
            case "阴":
                mFragSv.setBackgroundResource(R.mipmap.iq_yin);
                break;
            case "小雨":
            case "中雨":
                mFragSv.setBackgroundResource(R.mipmap.iq_xiaoyu);
                break;
            case "阵雨":
                mFragSv.setBackgroundResource(R.mipmap.iq_zhenyu);
                break;
            case "小雪":
            case "阵雪":
                mFragSv.setBackgroundResource(R.mipmap.iq_xiaoxue);
                break;
        }
    }


    private void putForecastDate(ForecastBean forecastBean) {
        List<ForecastBean.DataBean.DailyForecastBean> forecastList = forecastBean.getData().getDaily_forecast();
        for (int i = 0; i < forecastList.size(); i++) {
            //Log.i("forecast",forecastList.get(i).toString());
            //创建item里面的元素填充
            View itemview = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_center,null);
            itemview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            mFragCenterLayout.addView(itemview);
            TextView mItemCenterTvDate = itemview.findViewById(R.id.item_center_tv_date);
            TextView mItemCenterTvCon = itemview.findViewById(R.id.item_center_tv_con);
            TextView mItemCenterTvTemp = itemview.findViewById(R.id.item_center_tv_temp);
            ImageView mItemCenterIv = itemview.findViewById(R.id.item_center_iv);
            //数据填充
            ForecastBean.DataBean.DailyForecastBean forecastBean1 = forecastList.get(i);
            mItemCenterTvDate.setText(forecastBean1.getDate());
            mItemCenterTvCon.setText(forecastBean1.getCond_txt_d());
            mItemCenterTvTemp.setText(forecastBean1.getTmp_min()+"℃~"+forecastBean1.getTmp_max()+"℃");
            //根据天气设置图片
            switch (forecastBean1.getCond_txt_d()) {
                case "晴":
                    mItemCenterIv.setImageResource(R.mipmap.qingtian);
                    break;
                case "多云":
                    mItemCenterIv.setImageResource(R.mipmap.duoyun);
                    break;
                case "阴":
                    mItemCenterIv.setImageResource(R.mipmap.yintian);
                    break;
                case "小雨":
                    mItemCenterIv.setImageResource(R.mipmap.xiaoyu);
                    break;
                case "中雨":
                    mItemCenterIv.setImageResource(R.mipmap.zhongyu);
                    break;
                case "阵雨":
                    mItemCenterIv.setImageResource(R.mipmap.dayu);
                    break;
                case "小雪":
                    mItemCenterIv.setImageResource(R.mipmap.xiaoxue);
                    break;
                case "阵雪":
                    mItemCenterIv.setImageResource(R.mipmap.daxue);
                    break;
            }
        }
    }
    private void putHourlyDate(HourlyBean hourlyBean){
        List<HourlyBean.DataBean.HourlyBean1> hourlyBean1List = hourlyBean.getData().getHourly();
        itemViewList = new ArrayList<>();
        for (int i = 0; i < hourlyBean1List.size(); i++) {
            View itemview = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_hourly,null);
            itemview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            mFragHourlyLayout.addView(itemview);
            TextView mItemHourlyTvDate = itemview.findViewById(R.id.item_hourly_tv_date);
            TextView mItemHourlyTvCon = itemview.findViewById(R.id.item_hourly_tv_con);
            TextView mItemHourlyTvTemp = itemview.findViewById(R.id.item_hourly_tv_temp);
            ImageView mItemHourlyIv = itemview.findViewById(R.id.item_hourly_iv);
            //数据填充
            HourlyBean.DataBean.HourlyBean1 hourlyBean1 = hourlyBean1List.get(i);
            mItemHourlyTvDate.setText(hourlyBean1.getTime().substring(hourlyBean1.getTime().length()-5,hourlyBean1.getTime().length()-3)+"时");
            mItemHourlyTvCon.setText(hourlyBean1.getCond_txt());
            mItemHourlyTvTemp.setText(hourlyBean1.getTmp()+"℃");
            //根据天气设置图片
            switch (hourlyBean1.getCond_txt()) {
                case "晴":
                    mItemHourlyIv.setImageResource(R.mipmap.qingtian);
                    break;
                case "多云":
                    mItemHourlyIv.setImageResource(R.mipmap.duoyun);
                    break;
                case "阴":
                    mItemHourlyIv.setImageResource(R.mipmap.yintian);
                    break;
                case "小雨":
                    mItemHourlyIv.setImageResource(R.mipmap.xiaoyu);
                    break;
                case "中雨":
                    mItemHourlyIv.setImageResource(R.mipmap.zhongyu);
                    break;
                case "阵雨":
                    mItemHourlyIv.setImageResource(R.mipmap.dayu);
                    break;
                case "小雪":
                    mItemHourlyIv.setImageResource(R.mipmap.xiaoxue);
                    break;
                case "阵雪":
                    mItemHourlyIv.setImageResource(R.mipmap.daxue);
                    break;
            }
            itemViewList.add(itemview);
            itemview.setVisibility(View.GONE);
        }
    }
    private void putNowDate(NowBean nowBean) {
        System.out.println(nowBean.toString());
        //实时温度
        mFragTvNowtemp.setText(nowBean.getData().getNow().getTmp()+"℃");
        //城市
        mFragTvCity.setText(nowBean.getData().getBasic().getLocation());
        //实时天气
        mFragTvCondition.setText(nowBean.getData().getNow().getCond_txt());
        //更新时间
        mFragTvDate.setText(nowBean.getData().getUpdate().getLoc().substring(0,10));
        //风
        mFragTvWind.setText(nowBean.getData().getNow().getWind_dir()+":"+nowBean.getData().getNow().getWind_sc()+"级");
        //降水量
        if(nowBean.getData().getNow().getPcpn().equals("0.0")){
            mFragTvPcpn.setText("无降水");
        }else {
            mFragTvPcpn.setText("降水量:" + nowBean.getData().getNow().getPcpn() + "MM");
        }
    }
    private void putLifeDate(LifeBean lifeBean){
        List<LifeBean.DataBean.LifestyleBean> lifestyleBeanList = lifeBean.getData().getLifestyle();
        FragmentForecastAdapter fragmentForecastAdapter = new FragmentForecastAdapter(getActivity(), lifestyleBeanList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),3);
        manager.setOrientation(RecyclerView.VERTICAL);

        mFragFRv.setLayoutManager(manager);
        mFragFRv.setAdapter(fragmentForecastAdapter);
    }
    private void initView(View view) {
        //初始化
        mFragSv = view.findViewById(R.id.frag_sv);
        mFragLayout = view.findViewById(R.id.frag_layout);
        mFragTvNowtemp = view.findViewById(R.id.frag_tv_nowtemp);
        mFragTvCity = view.findViewById(R.id.frag_tv_city);
        mFragTvCondition = view.findViewById(R.id.frag_tv_condition);
        mFragTvDate = view.findViewById(R.id.frag_tv_date);
        mFragTvWind = view.findViewById(R.id.frag_tv_wind);
        mFragTvPcpn = view.findViewById(R.id.frag_tv_pcpn);
        mFragCenterLayout = view.findViewById(R.id.frag_center_layout);
        mFragHourlyLayout = view.findViewById(R.id.frag_hourly_layout);
        mFragHourlyTv = view.findViewById(R.id.frag_hourly_tv);
        mFragFRv = view.findViewById(R.id.frag_forecast_rv);

        mFragHourlyLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
