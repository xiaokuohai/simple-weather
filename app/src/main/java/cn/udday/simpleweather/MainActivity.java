package cn.udday.simpleweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.HourlyBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.adapter.WeatherFragmentAdapter;
import cn.udday.simpleweather.db.DBManager;
import cn.udday.simpleweather.utils.Constants;
import cn.udday.simpleweather.utils.HttpBackListenter;
import cn.udday.simpleweather.utils.Net;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private RelativeLayout mMainBaseLayout;
    private ImageView mMainIvAdd;
    private ImageView mMainIvMore;
    private LinearLayout mMainLayoutPoint;
    private ViewPager2 mMainVp;
    //viewpager数据源集合
    List<Fragment> fragmentList;
    //viewpager指示
    List<ImageView> imageViewList;
    //传入的城市集合
    private ArrayList<String> cityList;

    private WeatherFragmentAdapter adapter;
    private SharedPreferences bg;
    private int bgid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNet();
        initView();
        changeBg();
        setView();
        //搜索界面传值
        getCityFromSearch();
        initPager();
        setPager();
    }

    private void initNet() {
        cityList = DBManager.queryAllCityName();
        if (cityList.size() == 0){
            cityList.add("潼南");
        }
        //for (int i = 0; i < cityList.size(); i++) {
            //int finalI = i;
//            new Net(cityList.get(i), new HttpBackListenter() {
//                @Override
//                public void onSuccess(NowBean nowBean, ForecastBean forecastBean, LifeBean lifeBean, HourlyBean hourlyBean) {
//                    int t = DBManager.upDateDateByCity(cityList.get(finalI), nowBean.toString(), Constants.DATE_NOW);
//                    DBManager.upDateDateByCity(cityList.get(finalI), forecastBean.toString(), Constants.DATE_FORECAST);
//                    DBManager.upDateDateByCity(cityList.get(finalI), lifeBean.toString(), Constants.DATE_LIFE);
//                    DBManager.upDateDateByCity(cityList.get(finalI), hourlyBean.toString(), Constants.DATE_HOURLY);
//                    if (t <= 0) {
//                        //更新数据库失败，及没有这个城市，就增加这条记录
//                        DBManager.addCityDate(cityList.get(finalI), nowBean.toString(), Constants.DATE_NOW);D
//                        DBManager.addCityDate(cityList.get(finalI), forecastBean.toString(), Constants.DATE_FORECAST);
//                        DBManager.addCityDate(cityList.get(finalI), lifeBean.toString(), Constants.DATE_LIFE);
//                        DBManager.addCityDate(cityList.get(finalI), hourlyBean.toString(), Constants.DATE_HOURLY);
//                    }
//                }
//
//                @Override
//                public void onError(Call call, Throwable t) {
//
//                }
//            });
        //}

    }

    //搜索界面跳转接受值
    private void getCityFromSearch() {
    Intent intent = getIntent();
    String city = intent.getStringExtra("city");
    //判断是否存在于list
        if (!cityList.contains(city) && city != null){
            cityList.add(city);
        }
    }

    private void setPager() {
        adapter = new WeatherFragmentAdapter(MainActivity.this, fragmentList);
        mMainVp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mMainVp.setAdapter(adapter);
        //创建下方指示
        initPoint();
        //设置最后一个添加的为默认的显示
        mMainVp.setCurrentItem(fragmentList.size()-1);

        //设置ViewPager页面监听
        setPagerListener();
    }

    private void setPagerListener() {
        //设置监听，与小圆点同步
        mMainVp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                for (int i = 0; i < imageViewList.size(); i++) {
                    imageViewList.get(i).setImageResource(R.mipmap.a1);
                }
                imageViewList.get(position).setImageResource(R.mipmap.a3);
            }
        });
    }

    private void initPoint() {
        //创建下方指示
        for (int i = 0; i < fragmentList.size(); i++) {
            ImageView mBottomPointIv = new ImageView(this);
            mBottomPointIv.setImageResource(R.mipmap.a1);
            mBottomPointIv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mBottomPointIv.getLayoutParams();
            layoutParams.setMargins( 0,0,20,0);
            //添加到View中
            imageViewList.add(mBottomPointIv);
            mMainLayoutPoint.addView(mBottomPointIv);
        }
        imageViewList.get(imageViewList.size()-1).setImageResource(R.mipmap.a3);
    }

    private void initPager() {
        //创建Fragment对象，添加到viewPager数据源中
        for (int i = 0; i < cityList.size(); i++) {
            WeatherFragment weatherFragment = new WeatherFragment();
            //将城市名字传入WeatherFragment中
            Bundle bundle = new Bundle();
            bundle.putString("city",cityList.get(i));
            weatherFragment.setArguments(bundle);
            fragmentList.add(weatherFragment);
        }

    }

    private void initView() {
        mMainBaseLayout = findViewById(R.id.main_base_layout);
        mMainIvAdd = findViewById(R.id.main_iv_add);
        mMainIvMore = findViewById(R.id.main_iv_more);
        mMainLayoutPoint = findViewById(R.id.main_layout_point);
        mMainVp = findViewById(R.id.main_vp);

        fragmentList = new ArrayList<>();

        imageViewList = new ArrayList<>();
    }

    public void setView(){
        mMainIvAdd.setOnClickListener(this);
        mMainIvMore.setOnClickListener(this);


    }
    //换壁纸
    private void changeBg() {
        bg = getSharedPreferences("bg", MODE_PRIVATE);
        bgid = bg.getInt("bgid", 2);
        switch (bgid) {
            case 0:
                mMainBaseLayout.setBackgroundResource(R.mipmap.bg);
                break;
            case 1:
                mMainBaseLayout.setBackgroundResource(R.mipmap.bg2);
                break;
            case 2:
                mMainBaseLayout.setBackgroundResource(R.mipmap.bg3);
                break;
        }

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.main_iv_add:
            intent.setClass(this,CityManagerActivity.class);
                break;
            case R.id.main_iv_more:
            intent.setClass(this,MoreActivity.class);
                break;
        }
        startActivity(intent);
    }


}