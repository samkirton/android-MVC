package com.architecture.latest.app.cake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.architecture.latest.R;
import com.architecture.latest.app.interaction.ui.ObservingAdapter;
import com.architecture.latest.system.entity.Cake;

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