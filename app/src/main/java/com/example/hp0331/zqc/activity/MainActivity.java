package com.example.hp0331.zqc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp0331.zqc.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_location, R.id.iv_userimg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_location:
                break;
            case R.id.iv_userimg:
                break;
        }
    }
}
