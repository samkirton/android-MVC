package com.memtrip.mvc.controller.app.cake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.memtrip.mvc.R;
import com.memtrip.mvc.controller.ui.ListAdapter;
import com.memtrip.mvc.system.entity.Cake;

class CakesAdapter extends ListAdapter<Cake, CakeViewHolder> {

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