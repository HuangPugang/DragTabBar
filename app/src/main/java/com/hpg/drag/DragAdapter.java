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
public class DragAdapter extends BaseAdapter {

    private List<ItemBean> mList ;

    public DragAdapter(List<ItemBean> list){
        mList = list;
    }
    public void setDataChanged(List<ItemBean> list){
        mList = list;
        notifyDataSetChanged();
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drag_gird,null);
            holder.textView = (TextView) convertView.findViewById(R.id.item_text);
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        if (mList.get(position).isChoose()){
            convertView.setAlpha(0.5f);
        }else {
            convertView.setAlpha(1.0f);
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
