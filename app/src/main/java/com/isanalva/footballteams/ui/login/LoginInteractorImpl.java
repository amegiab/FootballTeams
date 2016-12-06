package com.isanalva.footballteams.ui.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractorImpl implements LoginInteractor {

    private final String USERNAME = "user";
    private final String PASSWORD = "pass";

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username) || !TextUtils.equals(USERNAME,username)){
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password) || !TextUtils.equals(PASSWORD,password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
