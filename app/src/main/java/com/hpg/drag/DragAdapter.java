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
public class DragAdapter extends MyAdapter {

//    private List<ItemBean> mList ;

    public DragAdapter(List<ItemBean> list){
        mList = list;
    }
    public void setDataChanged(List<ItemBean> list){
        mList = list;
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drag_gird,null);
        }
        ItemBean itemBean = (ItemBean) mList.get(position);
        if (itemBean.isChoose()){
            convertView.setAlpha(0.5f);
        }else {
            convertView.setAlpha(1.0f);
        }
        TextView textView = ViewHolder.get(convertView,R.id.item_text);
        textView.setText(itemBean.getTitle());
        ImageView imageView = ViewHolder.get(convertView,R.id.item_image);
        imageView.setImageResource(itemBean.getResourceId());
        return convertView;
    }


    class Holder{
        TextView textView ;
        ImageView imageView;
    }
}
