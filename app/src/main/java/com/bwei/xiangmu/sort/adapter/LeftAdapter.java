package com.bwei.xiangmu.sort.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bwei.xiangmu.R;
import com.bwei.xiangmu.sort.bean.LeftBean;

/**
 * Created by Long° Engagement on 2017/11/14.
 */

public class LeftAdapter extends BaseAdapter{
    LeftBean leftBean;
    Context context;

    public LeftAdapter(LeftBean leftBean, Context context) {
        this.leftBean = leftBean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return leftBean.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return leftBean.getData().get(i);
    }

    public  interface ClickName{
        void Clickname(int cid);
    }
    public   ClickName clickName;

    public void setClickName(ClickName clickName) {
        this.clickName = clickName;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;
        if(view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.sort_left,null);
            viewHolder = new MyViewHolder();
            viewHolder.tv= view.findViewById(R.id.sort_left_tv);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (MyViewHolder) view.getTag();
        }
        viewHolder.tv.setText(leftBean.getData().get(i).getName());
        viewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("main",leftBean.getData().get(i).getCid()+"");
                clickName.Clickname(leftBean.getData().get(i).getCid());
            }
        });
        return view;
    }
    class MyViewHolder{
        TextView tv;
    }
}
