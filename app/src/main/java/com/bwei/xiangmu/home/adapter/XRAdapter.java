package com.bwei.xiangmu.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.xiangmu.R;
import com.bwei.xiangmu.home.bean.HomeBean;
import com.bwei.xiangmu.utils.GlideImaGlideImageLoader;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by Long° Engagement on 2017/11/9.
 */

public class XRAdapter extends XRecyclerView.Adapter<RecyclerView.ViewHolder>{
    HomeBean.DataBean list;
    Context context;
    ArrayList mlist;
    ArrayList mlist2;
    private ArrayList<HomeBean.DataBean.Ad5Bean> ad5;
    private enum Item_Type{
        Type_one,Type_two,Type_three,Type_fore,Type_five,Type_six;
    }

    public XRAdapter(HomeBean.DataBean list, Context context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Item_Type.Type_one.ordinal()) {
            View mView = LayoutInflater.from(context).inflate(R.layout.item_a, null);
            ViewHolderA viewHolder = new ViewHolderA(mView);
            return viewHolder;

        }else if(viewType==Item_Type.Type_two.ordinal()){
            View view = LayoutInflater.from(context).inflate(R.layout.item_b,parent,false);
            ViewHolderB viewHolderB = new ViewHolderB(view);
            return viewHolderB;
        }
        else if(viewType ==Item_Type.Type_three.ordinal()){
            View viewc = LayoutInflater.from(context).inflate(R.layout.item_c,parent,false);
            ViewHolderC viewHolderc = new ViewHolderC(viewc);
            return viewHolderc;
        }
        else if(viewType == Item_Type.Type_fore.ordinal()){
            View viewd = LayoutInflater.from(context).inflate(R.layout.item_d,parent,false);
           ViewHolderD viewHolderD = new ViewHolderD(viewd);
            return viewHolderD;
        }
        else if(viewType ==Item_Type.Type_five.ordinal()){
            View viewe = LayoutInflater.from(context).inflate(R.layout.item_e,parent,false);
            ViewHolderE viewHolderE = new ViewHolderE(viewe);
            return viewHolderE;
        }
        else if(viewType==Item_Type.Type_six.ordinal()){
            View viewf = LayoutInflater.from(context).inflate(R.layout.item_e,parent,false);
            ViewHolderF viewHolderF = new ViewHolderF(viewf);
            return viewHolderF;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if(holder instanceof  ViewHolderA){
        mlist = new ArrayList();
        for (int i =0;i<list.getAd1().size();i++){
            mlist.add(list.getAd1().get(i).getImage());

        }
        ((ViewHolderA) holder).mbanner.setImageLoader(new GlideImaGlideImageLoader());
        ((ViewHolderA) holder).mbanner.setImages(mlist);
        ((ViewHolderA) holder).mbanner.start();

    }
        else if(holder instanceof ViewHolderB){
        List<HomeBean.DataBean.Ad5Bean> ad5 = list.getAd5();
        ViewHolderB holderB = (ViewHolderB) holder;
        holderB.mrecyclerView.setLayoutManager(new GridLayoutManager(context,ad5.size()));
        Foot_TwoAdapter adapter = new Foot_TwoAdapter(ad5, context);
        holderB.mrecyclerView.setAdapter(adapter);
        adapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context,"我点击了",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        });
      }
        else if(holder instanceof ViewHolderC){
                List<HomeBean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoListBeen =list.getActivityInfo().getActivityInfoList();
                ViewHolderC holderC = (ViewHolderC) holder;
        holderC.mRecyclerView.setLayoutManager(new GridLayoutManager(context,activityInfoListBeen.size()));
        Foot_ThreeAdapter adapter = new Foot_ThreeAdapter(activityInfoListBeen,context);
        holderC.mRecyclerView.setAdapter(adapter);
        holderC.countdownView.start(900000000);

        }
        else if(holder instanceof ViewHolderD){
        mlist2=new ArrayList();
        for(int i=0;i<list.getAd1().size();i++){
            mlist2.add(list.getSubjects().get(i).getDescImage());
        }
        //设置图片加载器
        ((ViewHolderD) holder).mbanner.setImageLoader(new GlideImageLoader());
        ((ViewHolderD) holder).mbanner.setImages(mlist2);
        ((ViewHolderD) holder).mbanner.start();

    }
        else if(holder instanceof ViewHolderE){
        List<HomeBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList = list.getSubjects().get(2).getGoodsList();
        ViewHolderE holderE = (ViewHolderE) holder;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holderE.rv.setLayoutManager(linearLayoutManager);
        Foot_FourAdapater adapter = new Foot_FourAdapater(goodsList,context);
        holderE.rv.setAdapter(adapter);
    }
        else  if(holder instanceof ViewHolderF){
        List<HomeBean.DataBean.DefaultGoodsListBean> defaultGoodsList = list.getDefaultGoodsList();
        ViewHolderF holderF = (ViewHolderF) holder;
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);

        holderF.rv.setLayoutManager(linearLayoutManager2);

        Foot_FiveAdapter adapter = new Foot_FiveAdapter(defaultGoodsList,context);
        holderF.rv.setAdapter(adapter);

    }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return Item_Type.Type_one.ordinal();
        }
        else if(position==1){
            return Item_Type.Type_two.ordinal();
        }
        else if(position==2){
            return Item_Type.Type_three.ordinal();
        }
        else if(position==3){
            return Item_Type.Type_fore.ordinal();
        }
       else if(position==4){
            return Item_Type.Type_five.ordinal();
        }
         else if(position==5){
            return Item_Type.Type_six.ordinal();
        }
        return -1;
    }

    class ViewHolderA extends RecyclerView.ViewHolder {
        public Banner mbanner;

        public ViewHolderA(View itemView) {
            super(itemView);
            mbanner = (Banner) itemView.findViewById(R.id.mybanner);
        }
    }
    class ViewHolderB extends RecyclerView.ViewHolder{
    RecyclerView mrecyclerView;
        public ViewHolderB(View itemView) {
            super(itemView);
            mrecyclerView = itemView.findViewById(R.id.id_recyclerview);

        }
    }
    class ViewHolderC extends RecyclerView.ViewHolder{
        public RecyclerView mRecyclerView;
        public CountdownView countdownView;
        public ViewHolderC(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.id_recyclerview);
            countdownView = (CountdownView) itemView.findViewById(R.id.countdownView);
        }
    }
    class ViewHolderD extends RecyclerView.ViewHolder{
        public Banner mbanner;
        public ViewHolderD(View itemView) {
            super(itemView);
            mbanner   = itemView.findViewById(R.id.mybanner);
        }
    }
    class ViewHolderE extends RecyclerView.ViewHolder {
        RecyclerView rv;

        public ViewHolderE(View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.id_recyclerview);
        }
    }
    class ViewHolderF extends RecyclerView.ViewHolder {
        RecyclerView rv;
        TextView tv;
        public ViewHolderF(View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.id_recyclerview);
            tv = itemView.findViewById(R.id.tv3);
        }
    }

}
