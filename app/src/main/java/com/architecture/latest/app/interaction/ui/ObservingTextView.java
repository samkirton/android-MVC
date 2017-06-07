package com.architecture.latest.app.interaction.ui;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class ObservingTextView extends AppCompatTextView implements ViewObservable<String> {

    public ObservingTextView(Context context) {
        this(context, null);
    }

    public ObservingTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObservingTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public Observer<String> attach() {
        return new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                setText(s);
            }
        };
    }
}