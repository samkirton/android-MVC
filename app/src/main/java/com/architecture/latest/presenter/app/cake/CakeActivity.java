package com.architecture.latest.presenter.app.cake;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.architecture.latest.R;
import com.architecture.latest.presenter.PresenterActivity;
import com.architecture.latest.presenter.interaction.ui.FrameErrorView;
import com.architecture.latest.presenter.interaction.ui.ViewObservable;
import com.architecture.latest.presenter.interaction.ui.ViewObserver;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.architecture.latest.presenter.app.cake.CakeComponent.CAKE_COMPONENT;

public class CakeActivity extends PresenterActivity<CakeViewModel, CakePresenter, CakeComponent> {

    @BindView(R.id.cake_activity_frame_error)
    FrameErrorView errorFrame;

    @BindView(R.id.cake_activity_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.cake_activity_progress_bar)
    ViewObservable<Boolean> progressBar;

    private CakesAdapter cakesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cake_activity);
        ButterKnife.bind(this);

        cakesAdapter = new CakesAdapter(this);

        recyclerView.setAdapter(cakesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        observeClicks(errorFrame.click());
    }

    @Override
    protected void observe(CakeViewModel viewModel) {
        super.observe(viewModel);

        viewModel.error().observe(this, errorFrame.attach(null));
        viewModel.showProgress().observe(this, progressBar.attach(new ViewObserver.Ui() {
            @Override
            public void present() {
                errorFrame.setVisibility(View.GONE);
            }
        }));

        viewModel.cakes().observe(this, cakesAdapter.attachNew(new ViewObserver.Ui() {
            @Override
            public void present() {
                recyclerView.setVisibility(View.VISIBLE);
            }
        }));
    }

    @Override
    protected CakePresenter createPresenter(CakeViewModel viewModel) {

        CakePresenter cakePresenter = new CakePresenter(viewModel);

        injector(CAKE_COMPONENT).inject(cakePresenter);

        return cakePresenter;
    }

    @Override
    protected Class<CakeViewModel> viewModel() {
        return CakeViewModel.class;
    }
}