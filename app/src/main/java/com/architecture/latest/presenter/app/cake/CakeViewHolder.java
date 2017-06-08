package com.architecture.latest.presenter.app.cake;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.architecture.latest.R;
import com.architecture.latest.system.entity.Cake;

import butterknife.BindView;
import butterknife.ButterKnife;

class CakeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cake_adapter_title)
    TextView titleTextView;

    @BindView(R.id.cake_adapter_body)
    TextView bodyTextView;

    CakeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void populate(Cake cake) {
        titleTextView.setText(cake.title());
        bodyTextView.setText(cake.desc());
    }
}
