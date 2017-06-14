package com.memtrip.mvc.controller.ui;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    private List<T> data = new ArrayList<>();

    protected List<T> data() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}