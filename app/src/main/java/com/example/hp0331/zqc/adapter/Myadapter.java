package com.example.hp0331.zqc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp0331.zqc.R;
import com.example.hp0331.zqc.beans.Fruits;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp0331 on 2017/6/20.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyHolder> {
    private OnRecyclerItemClickListener onRecyclerItemClickListener;
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener){
        this.onRecyclerItemClickListener=onRecyclerItemClickListener;
    }
    private Context context;
    private LayoutInflater inflater;
    private List<Fruits> list;

    public Myadapter(Context context,OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
        this.context = context;
        inflater=LayoutInflater.from(context);
        list=new ArrayList<>();
    }
    public void setData(List<Fruits> fruitsList){

        if (fruitsList.size()>0){
            list.clear();
            list.addAll(fruitsList);
        }
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final  View view=inflater.inflate(R.layout.item_recyclelist,viewGroup,false);
        MyHolder myHolder=new MyHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRecyclerItemClickListener!=null){
                    onRecyclerItemClickListener.onItemClick(view,(int)view.getTag());
                }
            }
        });
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.price.setText(list.get(i).getPrice());
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  class MyHolder extends RecyclerView.ViewHolder{
        public  ImageView imageView;
        public TextView name,price;
        public MyHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.iv_pic);
            name=(TextView)itemView.findViewById(R.id.tv_name);
            price=(TextView)itemView.findViewById(R.id.tv_price);
        }
    }
    public interface OnRecyclerItemClickListener {
        /**
         * item view 回调方法
         * @param view  被点击的view
         * @param position 点击索引
         */
        void onItemClick(View view, int position);
    }
}
