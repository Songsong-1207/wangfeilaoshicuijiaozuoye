package com.example.xiangmuone.login.presenter;


import android.util.Log;

import com.example.xiangmuone.base.BasePresenter;
import com.example.xiangmuone.login.bean.AffirmRegisterBean;
import com.example.xiangmuone.login.bean.VerfiedBean;
import com.example.xiangmuone.login.contract.LoginContract;
import com.example.xiangmuone.login.model.LoginModel;
import com.example.xiangmuone.net.INetCallBack;

public class LoginPresenter extends BasePresenter<LoginContract.ILoginView> implements LoginContract.ILoginPresenter {
    LoginContract.ILoginMode iLoginMode;

    public LoginPresenter() {
        iLoginMode = new LoginModel();
    }

    @Override
    public void getVerifend(String phonemub, String type) {
        iLoginMode.getVerified(phonemub, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean s) {
                mview.getVeridied(s);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {
        iLoginMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.checkSmsCodeResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void login(String phoneNum, String smsCode) {
        iLoginMode.getLogin(phoneNum, smsCode, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean affirmRegisterBean) {
                Log.i("TAG", "onSuccess: 登陆成功返回值"+affirmRegisterBean.toString());
                mview.getLoginResylt(affirmRegisterBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

}
