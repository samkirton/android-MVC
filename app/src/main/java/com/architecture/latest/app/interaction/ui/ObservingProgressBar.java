package com.architecture.latest.app.interaction.ui;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

public class ObservingProgressBar extends ProgressBar implements ViewObservable<Boolean> {

    public ObservingProgressBar(Context context) {
        super(context);
    }

    public ObservingProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservingProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public Observer<Boolean> attach() {
        return new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean inProgress) {
                if (inProgress != null && inProgress) {
                    setVisibility(View.VISIBLE);
                } else {
                    setVisibility(View.GONE);
                }
            }
        };
    }
}