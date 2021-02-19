package cn.udday.simpleweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        return convertView;
    }
    class ViewHolder{
        TextView mItemCityTVCity;
        TextView mItemCityTvTemp;
        public ViewHolder(View view){
            mItemCityTVCity = view.findViewById(R.id.item_city_tv_city);
            mItemCityTvTemp = view.findViewById(R.id.item_city_tv_temp);

        }

    }
}
