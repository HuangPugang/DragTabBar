package com.hpg.drag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static int TAB_HEIGHT;
    public static int[] tabLocation = new int[2];

    private List<ItemBean> mAllList = new ArrayList<>();
    private List<ItemBean> mDefaultList = new ArrayList<>();
    private LinearLayout mTabView;
    private GridView mDefaultGridView;
    private DragGridView mDragGridView;
    private String[] titles = {"店铺", "借钱", "发现", "我的", "设置", "店长", "订单"};
    private int[] sourceId = {R.drawable.ic_0, R.drawable.ic_1, R.drawable.ic_2, R.drawable.ic_3,
            R.drawable.ic_4, R.drawable.ic_5, R.drawable.ic_6};

    private DragAdapter mAdapterAll;
    private DefaultAdapter mAdapterDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView(){
        mDragGridView = (DragGridView) findViewById(R.id.drag_grid_view);
        mDefaultGridView = (GridView) findViewById(R.id.default_grid);
        mTabView = (LinearLayout) findViewById(R.id.ll_default);
    }

    private void initData(){
        ItemBean itemBean0 = new ItemBean(0, titles[0], sourceId[0], true);
        ItemBean itemBean1 = new ItemBean(1, titles[1], sourceId[1], true);
        ItemBean itemBean2 = new ItemBean(2, titles[2], sourceId[2], true);
        ItemBean itemBean3 = new ItemBean(3, titles[3], sourceId[3], true);
        ItemBean itemBean4 = new ItemBean(4, titles[4], sourceId[4], false);
        ItemBean itemBean5 = new ItemBean(5, titles[5], sourceId[5], false);
        ItemBean itemBean6 = new ItemBean(6, titles[6], sourceId[6], false);


        mAllList.add(itemBean0);
        mAllList.add(itemBean1);
        mAllList.add(itemBean2);
        mAllList.add(itemBean3);
        mAllList.add(itemBean4);
        mAllList.add(itemBean5);
        mAllList.add(itemBean6);

        mDefaultList.add(itemBean0);
        mDefaultList.add(itemBean1);
        mDefaultList.add(itemBean2);
        mDefaultList.add(itemBean3);


        mAdapterAll = new DragAdapter(mAllList);
        mAdapterDefault = new DefaultAdapter(mDefaultList);
        mDragGridView.setAdapter(mAdapterAll);
        mDefaultGridView.setAdapter(mAdapterDefault);
        mDragGridView.setItem(mAllList);
        mDragGridView.setOnChangeListener(new DragGridView.OnChangeListener() {

            @Override
            public void onChange(int from, int to) {
                Log.e("HPG", "FORM=" + from + ",to=" + to);
                ItemBean fromItem = mAllList.get(from);
                ItemBean toItem = mDefaultList.get(to);

                //有重复的，不替换
                for (int i = 0; i < mDefaultList.size(); i++) {
                    if (mDefaultList.get(i).getId() == fromItem.getId()) {
                        return;
                    }
                }

                for (int i = 0; i < mAllList.size(); i++) {
                    //设置被替换的为未选中
                    if (toItem.getId() == mAllList.get(i).getId()) {
                        mAllList.get(i).setIsChoose(false);
                    }
                    //设置新的为选中
                    if (fromItem.getId() == mAllList.get(i).getId()) {
                        mAllList.get(i).setIsChoose(true);
                    }

                }

                mDefaultList.remove(to);
                mDefaultList.add(to, fromItem);

                mAdapterAll.setDataChanged(mAllList);
                mAdapterDefault.notifyDataSetChanged();


            }
        });
        mTabView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTabView.getLocationOnScreen(tabLocation);
                TAB_HEIGHT = getViewMeasuredHeight(mTabView);
                Log.e("HPG", tabLocation[0] + " " + tabLocation[1]);
            }
        }, 200);


    }


    private int getViewMeasuredHeight(View view) {
        int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        view.measure(width, expandSpec);
        return view.getMeasuredWidth();
    }
}
