package com.memtrip.mvmp.presenter.app.cake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.memtrip.mvmp.R;
import com.memtrip.mvmp.presenter.interaction.ui.ObservingAdapter;
import com.memtrip.mvmp.system.entity.Cake;

class CakesAdapter extends ObservingAdapter<Cake, CakeViewHolder> {

    private final LayoutInflater inflater;

    CakesAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CakeViewHolder(inflater.inflate(R.layout.cake_adapter, null));
    }

    @Override
    public void onBindViewHolder(CakeViewHolder holder, int position) {
        holder.populate(data().get(position));
    }
}