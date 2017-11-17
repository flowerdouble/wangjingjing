package com.bwei.xiangmu.sort.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.sort.bean.RightBean;
import com.bwei.xiangmu.xq.view.xiangqing;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by Long° Engagement on 2017/11/14.
 */

public class RightItemAdapter extends BaseAdapter {
    ArrayList<RightBean.DataBean.ListBean> lists;
    // 上下文
    Context context;

    public RightItemAdapter(ArrayList<RightBean.DataBean.ListBean> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.sort_item, null);
            holder = new MyHolder();
            holder.tv = view.findViewById(R.id.sort_right_grid_item_tv);
            holder.img = view.findViewById(R.id.sort_right_grid_item_img);
            view.setTag(holder);
        } else {
            holder = (MyHolder) view.getTag();
        }
        Uri uri = Uri.parse(lists.get(i).getIcon());
        holder.img.setImageURI(uri);
        holder.tv.setText(lists.get(i).getName());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,xiangqing.class);
                intent.putExtra("pscid",lists.get(i).getPscid()+"");
                context.startActivity(intent);
                Log.d("main2","cid====="+lists.get(i).getPscid());
            }
        });
        return view;
    }
    class MyHolder {
        TextView tv;
        SimpleDraweeView img;
    }
}
