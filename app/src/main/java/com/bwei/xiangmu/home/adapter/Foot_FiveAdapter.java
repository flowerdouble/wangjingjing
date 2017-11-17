package com.bwei.xiangmu.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.xiangmu.R;
import com.bwei.xiangmu.home.bean.HomeBean;

import java.util.List;

/**
 * Created by wangjiao on 2017/10/24.
 */

public class Foot_FiveAdapter extends RecyclerView.Adapter<Foot_FiveAdapter.MyViewHolder>{
    Context context;
    List<HomeBean.DataBean.DefaultGoodsListBean> mdefault;

    public Foot_FiveAdapter( List<HomeBean.DataBean.DefaultGoodsListBean> mdefault,Context context) {
        this.context = context;
        this.mdefault = mdefault;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder=null;
        holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_f_1, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mdefault.get(position).getGoods_name());
        Glide.with(context).load(mdefault.get(position).getGoods_img()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mdefault.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        public MyViewHolder(View view)
        {
            super(view);
            imageView=(ImageView) view.findViewById(R.id.image6);
            textView = (TextView) view.findViewById(R.id.text6);
        }

    }
}
