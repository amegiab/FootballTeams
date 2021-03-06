package com.isanalva.footballteams.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.isanalva.footballteams.R;
import com.isanalva.footballteams.ui.teams.TeamsActivity;


public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void usernameError() {
        username.setError(getString(R.string.usernameerror));
    }

    @Override
    public void passwordError() {
        password.setError(getString(R.string.passworderror));
    }

    @Override
    public void home() {
        startActivity(new Intent(this, TeamsActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        presenter.authenticate(username.getText().toString(), password.getText().toString());
    }
}
