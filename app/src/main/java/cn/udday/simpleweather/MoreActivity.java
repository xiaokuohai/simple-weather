package cn.udday.simpleweather;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import cn.udday.simpleweather.db.DBManager;

public class MoreActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mMoreIvBack;
    private TextView mMoreTvVersion;
    private TextView mMoreTvCache;
    private TextView mMoreTvShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initView();
        setView();
    }

    private void setView() {
        String version = getVersion();
        mMoreTvVersion.setText("当前版本:" + version);
    }

    private String getVersion() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void initView() {
        mMoreIvBack = findViewById(R.id.more_iv_back);
        mMoreTvVersion = findViewById(R.id.more_tv_version);
        mMoreTvCache = findViewById(R.id.more_tv_cache);
        mMoreTvShare = findViewById(R.id.more_tv_share);

        mMoreIvBack.setOnClickListener(this);
        mMoreTvCache.setOnClickListener(this);
        mMoreTvShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more_iv_back:
                Intent intent = new Intent(MoreActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.more_tv_cache:
                clearDate();
                break;
            case R.id.more_tv_share:
                share("gitee.com/xiaokuohai/simple-weather" +
                        "\n" +
                        "www.udday.cn");
                break;
        }
    }

    private void share(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,s);
        startActivity(Intent.createChooser(intent,"简单天气"));
    }

    private void clearDate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示").setMessage("确实要删除所有缓存吗?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBManager.deleteAllDate();
                Toast.makeText(MoreActivity.this,"以清除全部缓存",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }).setNegativeButton("取消",null);
        builder.create().show();
    }
}