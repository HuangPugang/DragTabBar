package com.hpg.drag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by paul on 16/2/19.
 */
public class DefaultAdapter extends BaseAdapter {

    private List<ItemBean> mList ;

    public DefaultAdapter(List<ItemBean> list){
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder  holder;
        if (convertView==null){
            holder= new Holder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_default_grid,null);
            holder.textView = (TextView) convertView.findViewById(R.id.item_text);
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        holder.textView.setText(mList.get(position).getTitle());
        holder.imageView.setImageResource(mList.get(position).getResourceId());
        return convertView;
    }


    class Holder{
        TextView textView ;
        ImageView imageView;
    }

}
