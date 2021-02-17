package cn.udday.simpleweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import cn.udday.simpleweather.Adapter.WeatherFragmentAdapter;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private RelativeLayout mMainBottomLayout;
    private ImageView mMainIvAdd;
    private ImageView mMainIvMore;
    private LinearLayout mMainLayoutPoint;
    private ViewPager2 mMainVp;
    //viewpager数据源集合
    List<Fragment> fragmentList;
    //viewpager指示
    List<ImageView> imageViewList;
    //传入的城市集合
    ArrayList<String> cityList;

    private WeatherFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
        initPager();
        setPager();
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
        mMainBottomLayout = findViewById(R.id.main_bottom_layout);
        mMainIvAdd = findViewById(R.id.main_iv_add);
        mMainIvMore = findViewById(R.id.main_iv_more);
        mMainLayoutPoint = findViewById(R.id.main_layout_point);
        mMainVp = findViewById(R.id.main_vp);

        fragmentList = new ArrayList<>();
        cityList = new ArrayList<>();
        imageViewList = new ArrayList<>();
    }
    public void setView(){
        mMainIvAdd.setOnClickListener(this);
        mMainIvMore.setOnClickListener(this);
        
        if (cityList.size() == 0){
            cityList.add("tongnan");
            cityList.add("北京");
            cityList.add("成都");
        }
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.main_iv_add:

                break;
            case R.id.main_iv_more:

                break;
        }
    }
}