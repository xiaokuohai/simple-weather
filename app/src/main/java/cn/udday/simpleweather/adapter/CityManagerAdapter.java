package cn.udday.simpleweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import org.w3c.dom.Text;

import java.util.List;

import cn.udday.simpleweather.Beans.NowBean;
import cn.udday.simpleweather.R;

public class CityManagerAdapter extends BaseAdapter {
    Context context;
    List<NowBean> mnowBeanList;

    public CityManagerAdapter(Context context, List<NowBean> mnowBeanList) {
        this.context = context;
        this.mnowBeanList = mnowBeanList;
    }

    @Override
    public int getCount() {
        return mnowBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mnowBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_city_manager,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NowBean nowBean = mnowBeanList.get(position);
        viewHolder.mItemCityTVCity.setText(nowBean.getData().getBasic().getLocation());
        viewHolder.mItemCityTvTemp.setText(nowBean.getData().getNow().getTmp()+"℃");
        //图片填充
        switch (nowBean.getData().getNow().getCond_txt()) {
            case "晴":
                viewHolder.mItemCityIv.setBackgroundResource(R.mipmap.ia_qing);
                break;
            case "多云":
                viewHolder.mItemCityIv.setBackgroundResource(R.mipmap.ia_duoyun);
                break;
            case "阴":
                viewHolder.mItemCityIv.setBackgroundResource(R.mipmap.ia_yintian);
                break;
            case "小雨":
                viewHolder.mItemCityIv.setBackgroundResource(R.mipmap.ia_xiaoyu);
                break;
            case "中雨":
                viewHolder.mItemCityIv.setBackgroundResource(R.mipmap.ia_zhongyu);
                break;
            case "阵雨":
                viewHolder.mItemCityIv.setBackgroundResource(R.mipmap.ia_dayu);
                break;
            case "小雪":
            case "阵雪":
                viewHolder.mItemCityIv.setBackgroundResource(R.mipmap.ia_xiaoxue);
                break;
        }
        return convertView;
    }
    class ViewHolder{
        TextView mItemCityTVCity;
        TextView mItemCityTvTemp;
        ImageView mItemCityIv;
        public ViewHolder(View view){
            mItemCityIv = view.findViewById(R.id.item_city_iv);
            mItemCityTVCity = view.findViewById(R.id.item_city_tv_city);
            mItemCityTvTemp = view.findViewById(R.id.item_city_tv_temp);

        }

    }
}
