package com.bwei.xiangmu.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwei.xiangmu.R;
import com.bwei.xiangmu.home.bean.HomeBean;

import java.util.List;

/**
*@作者：王京京
 * @创建日期 2017/11/11 7:47
 *类的用途：
*/

public class Foot_ThreeAdapter  extends RecyclerView.Adapter<Foot_ThreeAdapter.MyViewHolder>{
    Context context;
    List<HomeBean.DataBean.ActivityInfoBean.ActivityInfoListBean> info;

    public Foot_ThreeAdapter(List<HomeBean.DataBean.ActivityInfoBean.ActivityInfoListBean> info, Context context) {
        this.info = info;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder=null;
        holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_c_1, parent, false));
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        for (int i = 0; i < 3; i++) {
            Glide.with(context).load(info.get(position).getActivityImg()).into(holder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return info.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        public MyViewHolder(View view)
        {
            super(view);
            imageView=(ImageView) view.findViewById(R.id.image2);
        }

    }


}

