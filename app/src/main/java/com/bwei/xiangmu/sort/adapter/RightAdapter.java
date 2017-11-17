package com.bwei.xiangmu.sort.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.sort.bean.RightBean;
import com.bwei.xiangmu.sort.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long° Engagement on 2017/11/14.
 */

public class RightAdapter extends BaseAdapter {
    RightBean rightBean;
    // 上下文
    Context context;
    ArrayList<RightBean.DataBean.ListBean> right_lists;

    public RightAdapter(RightBean rightBean, Context context) {
        this.rightBean = rightBean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return rightBean.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return rightBean.getData().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public interface GetItemData{
        void getItemData(String name,String pscid);
    }
    private GetItemData getItemData;

    public void GetItemData(GetItemData getItemData) {
        this.getItemData = getItemData;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.sort_riht, null);
            holder = new MyHolder();
            holder.tv = view.findViewById(R.id.sort_right_title);
            holder.gridView = view.findViewById(R.id.sort_right_grid);
            view.setTag(holder);
        } else {
            holder = (MyHolder) view.getTag();
        }
        Log.d("name",rightBean.getData().get(i).getName());
        holder.tv.setText(rightBean.getData().get(i).getName());
        right_lists = new ArrayList<>();
        for (int j = 0; j < rightBean.getData().get(i).getList().size(); j++) {
            List<RightBean.DataBean.ListBean> list = rightBean.getData().get(i).getList();
            RightBean.DataBean.ListBean listBean = list.get(j);
            right_lists.add(new RightBean.DataBean.ListBean(listBean.getIcon(), listBean.getName(), listBean.getPcid(), listBean.getPscid()));
        }
        //gridview
        final RightItemAdapter adapter = new RightItemAdapter(right_lists, context);
        holder.gridView.setAdapter(adapter);
        holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getItemData.getItemData(right_lists.get(i).getName(),right_lists.get(i).getPscid()+"");
            }
        });

        return view;
    }
    class MyHolder {
        TextView tv;
        MyGridView gridView;
    }
}
