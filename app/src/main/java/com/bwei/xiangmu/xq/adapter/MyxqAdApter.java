package com.bwei.xiangmu.xq.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.xq.bean.ParBean;
import com.bwei.xiangmu.xq.view.DetailsGoodsPageActivity;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Long° Engagement on 2017/11/17.
 */

public class MyxqAdApter  extends RecyclerView.Adapter<MyxqAdApter.MyViewHolder> {
    ParBean parBean;
    Context context;

    public MyxqAdApter(ParBean parBean, Context context) {
        this.parBean = parBean;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.xq_item, null));
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ParBean.DataBean bean = parBean.getData().get(position);
        String imgs = bean.getImages();
        String[] split = imgs.split("\\|");
        Uri uri = Uri.parse(split[0]);
        holder.img.setImageURI(uri);
        holder.title.setText(bean.getTitle());
        holder.subhead.setText(bean.getSubhead());
        holder.bargain.setText("商品原价 " + bean.getBargainPrice());
        holder.price.setText("￥商品现价"+bean.getPrice());
        holder.salenum.setText(bean.getSalenum() + "人已付款");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailsGoodsPageActivity.class);
                intent.putExtra("pid",parBean.getData().get(position).getPid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parBean.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // 图片
        SimpleDraweeView img;
        //       标题   商品介绍 商品原价 商品现价￥   xxx人付款
        TextView title, subhead, bargain, price, salenum;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.search_goods_img);
            title = itemView.findViewById(R.id.search_goods_title);
            subhead = itemView.findViewById(R.id.search_goods_subhead);
            bargain = itemView.findViewById(R.id.search_goods_bargainPrice);
            price = itemView.findViewById(R.id.search_goods_price);
            salenum = itemView.findViewById(R.id.search_goods_salenum);
        }
    }
}
