package cn.udday.simpleweather.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.udday.simpleweather.Beans.ForecastBean;
import cn.udday.simpleweather.Beans.LifeBean;
import cn.udday.simpleweather.MainActivity;
import cn.udday.simpleweather.MoreActivity;
import cn.udday.simpleweather.R;
import cn.udday.simpleweather.db.DBManager;

public class FragmentForecastAdapter extends RecyclerView.Adapter<FragmentForecastAdapter.MyViewHolder>{
    private Context context;
    private List<LifeBean.DataBean.LifestyleBean> lifestyleBeanList;
    private View inflater;
    public FragmentForecastAdapter(Context context, List<LifeBean.DataBean.LifestyleBean> lifestyleBeanList) {
        this.context = context;
        this.lifestyleBeanList = lifestyleBeanList;
    }

    @NonNull
    @Override
    public  MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context).inflate(R.layout.item_main_forecast,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mFragFTitle.setText(getTitle(lifestyleBeanList.get(position).getType()));
        holder.mFragFState.setText(lifestyleBeanList.get(position).getBrf());
        holder.mFragIv.setImageResource(getP(lifestyleBeanList.get(position).getType()));
        holder.mFragIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showtis(position);
            }
        });

    }

    private void showtis(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(getTitle(lifestyleBeanList.get(position).getType())).setMessage(lifestyleBeanList.get(position).getTxt());
        builder.setPositiveButton("确定",null);
        builder.create().show();
    }

    private String getTitle(String s) {
        String t ="无";
        switch (s){
            case "comf":
                t = "舒适度指数";
                break;
            case "drsg":
                t = "穿衣指数";
                break;
            case "flu":
                t = "感冒指数";
                break;
            case "sport":
                t = "运动指数";
                break;
            case "trav":
                t = "旅游指数";
                break;
            case "uv":
                t = "紫外线指数";
                break;
            case "cw":
                t = "洗车指数";
                break;
            case "air":
                t = "空气指数";
                break;
            case "ac":
                t = "空调开启指数";
                break;
            case "ag":
                t = "过敏指数";
            break;
            case "gl":
                t = "太阳镜指数";
            break;
            case "mu":
                t = "化妆指数";
            break;
            case "airc":
                t = "晾晒指数";
            break;
            case "ptfc":
                t = "交通指数";
            break;
            case "fsh":
                t = "钓鱼指数";
            break;
            case "spi":
                t = "防晒指数";
            break;
        }
        return t;
    }
    private int getP(String s){
        int t =0;
        switch (s){
            case "comf":
                t = R.mipmap.ic_comf;
                break;
            case "drsg":
                t = R.mipmap.ic_drsg;
                break;
            case "flu":
                t = R.mipmap.ic_flu;
                break;
            case "sport":
                t = R.mipmap.ic_sport;
                break;
            case "trav":
                t = R.mipmap.ic_trav;
                break;
            case "uv":
                t = R.mipmap.ic_uv;
                break;
            case "cw":
                t = R.mipmap.ic_comf;
                break;
            case "air":
                t = R.mipmap.ic_air;
                break;
            case "ac":
                t = R.mipmap.ic_ac;
                break;
            case "ag":
                t = R.mipmap.ic_ag;
                break;
            case "gl":
                t = R.mipmap.ic_comf;
                break;
            case "mu":
                t = R.mipmap.ic_comf;
                break;
            case "airc":
                t = R.mipmap.ic_comf;
                break;
            case "ptfc":
                t = R.mipmap.ic_comf;
                break;
            case "fsh":
                t = R.mipmap.ic_comf;
                break;
            case "spi":
                t = R.mipmap.ic_comf;
                break;
        }
        return t;
    }
    @Override
    public int getItemCount() {
        return lifestyleBeanList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mFragFTitle;
        ImageView mFragIv;
        TextView mFragFState;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             mFragFTitle = itemView.findViewById(R.id.frag_forecast_title);
             mFragIv = itemView.findViewById(R.id.frag_forecast_iv);
             mFragFState = itemView.findViewById(R.id.frag_forecast_state);
        }
    }
}
