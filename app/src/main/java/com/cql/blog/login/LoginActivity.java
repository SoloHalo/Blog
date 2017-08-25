package com.cql.blog.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cql.blog.R;
import com.cql.blog.base.BaseMvpActivity;

/**
 * Created by home on 2017/8/25.
 */

public class LoginActivity extends BaseMvpActivity<LoginPrenster,LoginModel> implements LoginContract.View{
    private EditText mEdUserName;
    private EditText mEdPassword;
    private Button mBtnLogin;

    public static void startActivity(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mEdUserName = findView(R.id.ed_username);
        mEdPassword = findView(R.id.ed_password);
        mBtnLogin = findView(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().doLogin();
            }
        });
    }

    @Override
    public void loginFail(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return mEdUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEdPassword.getText().toString();
    }
}
