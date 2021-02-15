package cn.udday.simpleweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.utils.RetrofitImpl;
import cn.udday.simpleweather.utils.WApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private RelativeLayout mMainBottomLayout;
    private ImageView mMainIvAdd;
    private ImageView mMainIvMore;
    private LinearLayout mMainLayoutPoint;
    private ViewPager2 mMainVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void initView() {
        mMainBottomLayout = findViewById(R.id.main_bottom_layout);
        mMainIvAdd = findViewById(R.id.main_iv_add);
        mMainIvMore = findViewById(R.id.main_iv_more);
        mMainLayoutPoint = findViewById(R.id.main_layout_point);
        mMainVp = findViewById(R.id.main_vp);
    }
    public void setView(){
        mMainIvAdd.setOnClickListener(this);
        mMainIvMore.setOnClickListener(this);
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