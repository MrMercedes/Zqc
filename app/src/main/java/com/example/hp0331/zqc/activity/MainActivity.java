package com.example.hp0331.zqc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp0331.zqc.MyApplication;
import com.example.hp0331.zqc.R;
import com.example.hp0331.zqc.beans.Fruits;
import com.example.hp0331.zqc.utils.EasyToast;
import com.example.hp0331.zqc.view.FlowLayoutManager;
import com.example.hp0331.zqc.view.Search_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_list)
    TextView tvList;
    @BindView(R.id.iv_userimg)
    ImageView ivUserimg;
    @BindView(R.id.ll_head)
    LinearLayout llHead;
    @BindView(R.id.recycle_list)
    RecyclerView recycleList;
    @BindView(R.id.searchview)
    Search_View searchview;
    private MyApplication mApp;
    private List<Fruits> list=new ArrayList<>();
    private  FlowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
        ButterKnife.bind(this);
        mApp = (MyApplication) getApplication();
        initview();

    }
    public void setData(){

        for (int i=0;i<=20;i++){
        Fruits fruits=new Fruits();
        fruits.setName("苹果"+i);
        fruits.setPrice(10*i+"/kg");
        fruits.setImage(R.mipmap.apple);
        list.add(fruits);
        }
    }
    public void initview() {
        adapter=new FlowAdapter();
        tvLocation.setText(mApp.bmLocation.getCity());
        recycleList.setLayoutManager(new FlowLayoutManager(this));
        recycleList.setAdapter(adapter);

    }

    @OnClick({R.id.tv_location, R.id.iv_userimg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_location:
                EasyToast.INSTANCE.show(this,"current address:"+mApp.bmLocation.getAddress(), Toast.LENGTH_SHORT);
                break;
            case R.id.iv_userimg:
                break;


        }
    }
    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int TYPE_WIDTHER = 1;
        private static final int TYPE_NORMAL = 2;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_WIDTHER) {
                return new MyHolder(View.inflate(MainActivity.this, R.layout.item_fruit, null));
            } else {
                return new MyHolder(View.inflate(MainActivity.this, R.layout.item_fruit, null));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ImageView imageView = ((MyHolder) holder).img;
            TextView name=((MyHolder)holder).name;
            TextView price=((MyHolder)holder).price;
            imageView.setImageDrawable(getResources().getDrawable(list.get(position).getImage()));
            name.setText(list.get(position).getName());
            price.setText(list.get(position).getPrice());

        }

        @Override
        public int getItemViewType(int position) {
            if (position % 3 == 0) {
                return TYPE_WIDTHER;
            } else {
                return TYPE_NORMAL;
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            private ImageView img;
            private TextView name,price;

            public MyHolder(View itemView) {
                super(itemView);
                img = (ImageView) itemView.findViewById(R.id.iv_fruit);
                name=(TextView)itemView.findViewById(R.id.fruitname);
                price=(TextView)itemView.findViewById(R.id.fruitprice);
            }
        }
    }
}
