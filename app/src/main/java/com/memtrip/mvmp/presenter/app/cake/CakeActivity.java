package com.memtrip.mvmp.presenter.app.cake;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.memtrip.mvmp.R;
import com.memtrip.mvmp.presenter.PresenterActivity;
import com.memtrip.mvmp.presenter.interaction.model.ErrorModel;
import com.memtrip.mvmp.presenter.interaction.ui.FrameErrorView;
import com.memtrip.mvmp.system.entity.Cake;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.memtrip.mvmp.presenter.app.cake.CakeComponent.CAKE_COMPONENT;

public class CakeActivity extends PresenterActivity<CakeViewModel, CakePresenter, CakeComponent> {

    @BindView(R.id.cake_activity_frame_error)
    FrameErrorView errorFrame;

    @BindView(R.id.cake_activity_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.cake_activity_progress_bar)
    ProgressBar progressBar;

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

        viewModel.error().observe(this, new Observer<ErrorModel>() {
            @Override
            public void onChanged(@Nullable ErrorModel errorModel) {
                errorFrame.setVisibility(View.VISIBLE);
                errorFrame.title().setText(getResources().getString(errorModel.title().id()));
                errorFrame.body().setText(getResources().getString(errorModel.body().id()));
            }
        });

        viewModel.showProgress().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean showProgress) {
                errorFrame.setVisibility(View.GONE);
                progressBar.setVisibility(showProgress ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.cakes().observe(this, new Observer<List<Cake>>() {
            @Override
            public void onChanged(@Nullable List<Cake> cakes) {
                cakesAdapter.setData(cakes);
                recyclerView.setVisibility(View.VISIBLE);;
            }
        });
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