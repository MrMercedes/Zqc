package com.example.hp0331.zqc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp0331.zqc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.et_putinname)
    EditText etPutinname;
    @BindView(R.id.btn_checkname)
    Button btnCheckname;
    @BindView(R.id.et_pw1)
    EditText etPw1;
    @BindView(R.id.et_pw2)
    EditText etPw2;
    @BindView(R.id.btn_signup)
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_checkname, R.id.btn_signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_checkname:
                break;
            case R.id.btn_signup:
                break;
        }
    }
}
