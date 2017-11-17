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
 * Created by wangjiao on 2017/10/23.
 */

public class Foot_TwoAdapter extends RecyclerView.Adapter<Foot_TwoAdapter.MyViewHolder> {
    Context context;
    List<HomeBean.DataBean.Ad5Bean> ad5;

    public Foot_TwoAdapter(List<HomeBean.DataBean.Ad5Bean> ad5, Context context) {
        this.ad5 = ad5;
        this.context = context;
    }

    //条目点击
    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
//    SimpleDraweeView image;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_b_1, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(final MyViewHolder holder, int position){
        holder.tv.setText(ad5.get(position).getTitle());
        Glide.with(context).load(ad5.get(position).getImage()).into(holder.imageView);

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);

                }
            });
        }
    }
    @Override
    public int getItemCount() {

        return ad5.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;
        ImageView imageView;
        public  MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            imageView=(ImageView) view.findViewById(R.id.image);

        }
}

}
