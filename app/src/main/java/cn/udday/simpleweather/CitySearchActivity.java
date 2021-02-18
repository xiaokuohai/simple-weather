package cn.udday.simpleweather;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.HourlyBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.base.BaseActivity;
import cn.udday.simpleweather.db.DBManager;
import cn.udday.simpleweather.utils.Constants;
import cn.udday.simpleweather.utils.HttpBackListenter;
import cn.udday.simpleweather.utils.MyThrowable;
import cn.udday.simpleweather.utils.RetrofitImpl;
import cn.udday.simpleweather.utils.WApi;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.HttpException;

public class CitySearchActivity extends BaseActivity implements View.OnClickListener {

    private EditText mSearchEt;
    private TextView mSearchTv;
    private GridView mSearchGv;
    private ImageView mSearchIvSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_search);
        initView();
    }
    private void initView() {
        mSearchEt = findViewById(R.id.search_et);
        mSearchTv = findViewById(R.id.search_tv);
        mSearchGv = findViewById(R.id.search_gv);
        mSearchIvSubmit = findViewById(R.id.search_iv_submit);
        mSearchIvSubmit.setOnClickListener(this);
        //设置适配器
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, R.layout.item_city_search_hotcity, Constants.HOTCITYS);
        mSearchGv.setAdapter(stringArrayAdapter);
        loadDate("tt", new HttpBackListenter() {
            @Override
            public void onSuccess(NowBean nowBean, ForecastBean forecastBean, LifeBean lifeBean, HourlyBean hourlyBean) {

            }

            @Override
            public void onError(Call call, Throwable t){

                if(((MyThrowable)t).getMsg().equals(Constants.FAIL_CITY)){
                    
                }

            }
        });
    }

    @Override
    public void loadDate(String city, HttpBackListenter backListenter) {
        super.loadDate(city, backListenter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_iv_submit:
                String s = mSearchEt.getText().toString();
                if (!TextUtils.isEmpty(s)) {
                //先判断是否存在这个城市
                }else{
                    Toast.makeText(this,"输入内容不能为空!",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}