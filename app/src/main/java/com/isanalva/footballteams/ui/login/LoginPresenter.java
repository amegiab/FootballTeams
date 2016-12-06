package com.isanalva.footballteams.ui.login;

public interface LoginPresenter {

    void authenticate(String username, String password);

    void onDestroy();
}
