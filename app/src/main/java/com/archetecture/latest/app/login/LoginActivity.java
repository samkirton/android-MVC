package com.archetecture.latest.app.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.archetecture.latest.R;
import com.archetecture.latest.app.PresenterActivity;
import com.archetecture.latest.app.interaction.ui.Attachable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends PresenterActivity<LoginViewModel, LoginPresenter> implements LoginView {

    @BindView(R.id.textView)
    Attachable<String> textView;

    @BindView(R.id.login_activity_cta)
    Button ctaButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

        observeClicks(ctaButton);
    }

    @Override
    protected void observe(LoginViewModel viewModel) {
        super.observe(viewModel);

        viewModel.test().observe(this, textView.attach());
    }

    @Override
    protected LoginPresenter createPresenter(LoginViewModel viewModel) {
        return new LoginPresenter(viewModel, this);
    }

    @Override
    protected Class<LoginViewModel> viewModel() {
        return LoginViewModel.class;
    }
}