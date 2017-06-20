package com.example.hp0331.zqc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp0331.zqc.R;
import com.example.hp0331.zqc.adapter.Myadapter;
import com.example.hp0331.zqc.beans.Fruits;
import com.example.hp0331.zqc.view.CoordinatorMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyMainActivity extends AppCompatActivity {
    private Myadapter myadapter;
    private List<Fruits> list=new ArrayList<>();
    @BindView(R.id.recycle_list)
    RecyclerView recycleList;
    private long latestBackTime = 0;
    private static final long WAIT_TIME = 1500;

    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_write)
    TextView tvWrite;
    @BindView(R.id.coormain)
    CoordinatorMenu coormain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        ButterKnife.bind(this);
        setData();
        recycleList.setLayoutManager(new LinearLayoutManager(this));
        recycleList.setItemAnimator(new DefaultItemAnimator());
        myadapter=new Myadapter(this, new Myadapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        myadapter.setData(list);
        recycleList.setAdapter(myadapter);
    }

    public void setData(){
        for (int i=0;i<=20;i++){
            Fruits fruits=new Fruits();
            fruits.setName("苹果"+i);
            fruits.setPrice(10*i+"元/kg");
            fruits.setImage(R.mipmap.apple);
            list.add(fruits);
        }
    }
    @OnClick({R.id.iv_head, R.id.tv_write})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_head:
                if (coormain.isOpened()) {
                    coormain.closeMenu();
                } else {
                    coormain.openMenu();
                }
                break;
            case R.id.tv_write:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (coormain.isOpened()) {
            coormain.closeMenu();
        } else {
            long currentBackTime = System.currentTimeMillis();
            if (currentBackTime - latestBackTime > WAIT_TIME) {
                Toast.makeText(MyMainActivity.this, getString(R.string.toast_exit_confirm), Toast.LENGTH_SHORT).show();
                latestBackTime = currentBackTime;
            } else {
                super.onBackPressed();
            }
        }
    }
}
