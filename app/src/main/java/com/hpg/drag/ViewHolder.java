package com.hpg.drag;

import android.util.SparseArray;
import android.view.View;


/**
 * Created by paul on 16/2/19.
 */

public class ViewHolder {
    // I added a generic return type to reduce the casting noise in client code
    public static  <T extends View> T get(View view, int id) {
        SparseArray viewHolder = (SparseArray) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray();
            view.setTag(viewHolder);
        }
        View childView = (View) viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
