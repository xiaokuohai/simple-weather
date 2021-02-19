package cn.udday.simpleweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.utils.Constants;
import cn.udday.simpleweather.utils.MyThrowable;
import cn.udday.simpleweather.utils.RetrofitImpl;
import cn.udday.simpleweather.utils.WApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitySearchActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mSearchEt;
    private TextView mSearchTv;
    private GridView mSearchGv;
    private ImageView mSearchIvSubmit;
    private int code;
    private Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            code= msg.getData().getInt("one");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_search);
        initView();
        setListenter();
    }

    private void setListenter() {
        mSearchGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toMain(Constants.HOTCITYS[position]);
            }
        });
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

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_iv_submit:
                String s = mSearchEt.getText().toString();
                if (!TextUtils.isEmpty(s)) {
                //先判断是否存在这个城市
                    WApi wApi = RetrofitImpl.getRetrofit().create(WApi.class);
                    //实时天气
                    wApi.postNowJson(s).enqueue(new Callback<NowBean>() {
                        @Override
                        public void onResponse(Call<NowBean> call, Response<NowBean> response) {
                            toMain(s);
                        }

                        @Override
                        public void onFailure(Call<NowBean> call, Throwable t) {
                            Message message = new Message();
                            message.what = 1;
                            Bundle bundle = new Bundle();
                            bundle.putInt("one",((MyThrowable)t).getCode());
                            message.setData(bundle);
                            handler.sendMessage(message);
                        }
                    });
                    if (code == 422){
                        Toast.makeText(this,"你输入的城市未收录或者不存在",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this,"输入内容不能为空!",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    //搜索界面转到main，并且输去city
    private void toMain(String city) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("city",city);
        startActivity(intent);
    }
}