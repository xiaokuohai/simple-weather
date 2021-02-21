package cn.udday.simpleweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.udday.simpleweather.Beans.AllBean;
import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.adapter.CityManagerAdapter;
import cn.udday.simpleweather.db.DBManager;

public class CityManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mCityTopIvBack;
    private ImageView mCityIvDelete;
    private ListView mCityLv;
    private ImageView mCityIvAdd;
    private CityManagerAdapter adapter;
    //显示列表数据源
    List<NowBean> mNowBeanDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        initView();
        initDate();
        setView();

    }
//删除后回到这，获取数据，更新适配器
    @Override
    protected void onResume() {
        super.onResume();
        List<AllBean> allBeans = DBManager.queryAllDate();
        mNowBeanDate.clear();
        for (int i = 0; i < allBeans.size(); i++) {
            NowBean nowBean = allBeans.get(i).getNowBean();
            mNowBeanDate.add(nowBean);
        }
        //通知更新
        adapter.notifyDataSetChanged();
    }

    private void setView() {
        adapter = new CityManagerAdapter(this,mNowBeanDate);
        mCityLv.setAdapter(adapter);
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
        switch (v.getId()){
            case R.id.city_iv_add:
                int cityCount = DBManager.getCityCount();
                //如果城市有8个就不能申请了
                if (cityCount < 8){
                Intent intent = new Intent(this,CitySearchActivity.class);
                startActivity(intent);
                }else{
                    Toast.makeText(this,"最多存储8个城市,请删除后再添加",Toast.LENGTH_SHORT).show();
                }
            break;
            case R.id.city_iv_delete:
                Intent intent = new Intent(this,CityDeleteActivity.class);
                startActivity(intent);
            break;
            case R.id.city_top_iv_back:
                finish();
            break;
        }

    }
}