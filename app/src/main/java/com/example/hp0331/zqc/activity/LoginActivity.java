package com.example.hp0331.zqc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp0331.zqc.R;
import com.example.hp0331.zqc.utils.EasyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity  {
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.password)
    TextView password;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forgetpw)
    TextView tvForgetpw;
    @BindView(R.id.tv_signup)
    TextView tvSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public void checkpassword() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (username.equals("")) {
            EasyToast.INSTANCE.show(this, R.string.usernamenull, Toast.LENGTH_SHORT);
        }
        if (password.equals("")) {
            EasyToast.INSTANCE.show(this, R.string.passworenull, Toast.LENGTH_SHORT);
        }
        if (true) {
//        if (username.equals("刘正华")&&password.equals("2b")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            EasyToast.INSTANCE.show(this, R.string.nameorpwwrong, Toast.LENGTH_SHORT);
        }
    }

    @OnClick({R.id.btn_login, R.id.tv_forgetpw, R.id.tv_signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                checkpassword();
                break;
            case R.id.tv_forgetpw:
                break;
            case R.id.tv_signup:
                break;
        }
    }
}
