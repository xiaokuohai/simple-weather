package cn.udday.simpleweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.udday.simpleweather.adapter.CityDeleteAdapter;
import cn.udday.simpleweather.db.DBManager;

public class CityDeleteActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mDeleteIvBack;
     private ListView mDeleteLv;
    //listview的数据源
    private List<String> mDatas;
    private CityDeleteAdapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_delete);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<String> cityList = DBManager.queryAllCityName();
        mDatas.addAll(cityList);
        adpter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void initView() {
        mDeleteIvBack = findViewById(R.id.delete_iv_back);
        mDeleteLv = findViewById(R.id.delete_lv);
        mDatas = new ArrayList<>();

        mDeleteIvBack.setOnClickListener(this);

        adpter = new CityDeleteAdapter(this,mDatas);
        mDeleteLv.setAdapter(adpter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.delete_iv_back:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}