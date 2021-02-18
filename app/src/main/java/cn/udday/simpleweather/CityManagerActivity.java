package cn.udday.simpleweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.udday.simpleweather.Beans.NowBean;

public class CityManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mCityTopIvBack;
    private ImageView mCityIvDelete;
    private ListView mCityLv;
    private ImageView mCityIvAdd;
    //显示列表数据源
    List<NowBean> mNowBeanDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        initView();
        setView();
        initDate();
    }

    private void setView() {


    }

    private void initDate() {
        mNowBeanDate = new ArrayList<>();

    }

    private void initView() {
        mCityTopIvBack = findViewById(R.id.city_top_iv_back);
        mCityIvDelete = findViewById(R.id.city_iv_delete);
        mCityLv = findViewById(R.id.city_lv);
        mCityIvAdd = findViewById(R.id.city_iv_add);

        mCityIvAdd.setOnClickListener(this);
        mCityIvDelete.setOnClickListener(this);
        mCityTopIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.city_iv_add:
                intent.setClass(this,CitySearchActivity.class);
            break;
            case R.id.city_iv_delete:
                intent.setClass(this,CityDeleteActivity.class);
            break;
            case R.id.city_top_iv_back:
                finish();
            break;
        }
        startActivity(intent);
    }
}