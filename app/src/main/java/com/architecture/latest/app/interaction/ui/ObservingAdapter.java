package com.architecture.latest.app.interaction.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservingAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    private final List<T> data = new ArrayList<>();

    protected List<T> data() {
        return data;
    }

    public interface Ui {
        void present();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Observer<List<T>> attachNew(final Ui ui) {
        return new Observer<List<T>>() {
            @Override
            public void onChanged(@Nullable List<T> values) {
                if (values != null && values.size() > 0) {
                    data.clear();
                    data.addAll(values);
                }

                ui.present();
            }
        };
    }

    public Observer<List<T>> attachMore(final Ui ui) {
        return new Observer<List<T>>() {
            @Override
            public void onChanged(@Nullable List<T> values) {
                if (values != null && values.size() > 0) {
                    data.addAll(values);
                }

                ui.present();
            }
        };
    }
}