package cn.udday.simpleweather.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.udday.simpleweather.R;
import cn.udday.simpleweather.db.DBManager;

public class CityDeleteAdapter extends BaseAdapter {
    Context context;
    List<String> list;

    public CityDeleteAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_city_delete,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        String city = list.get(position);
        viewHolder.mDeleteTv.setText(city);
        viewHolder.mDeleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(city);
                //删除了提示Adapter更新
                notifyDataSetChanged();
                //删除
                int i = DBManager.deleteDateByCity(city);
                if (i == 1){
                    Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView mDeleteTv;
        ImageView mDeleteIv;
        public ViewHolder(View view){
            mDeleteTv = view.findViewById(R.id.item_delete_tv);
            mDeleteIv = view.findViewById(R.id.item_delete_iv);

        }
    }
}
