package com.memtrip.mvmp.presenter.interaction.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class ObservingEditText extends AppCompatEditText implements ViewObservable<String> {

    public ObservingEditText(Context context) {
        this(context, null);
    }

    public ObservingEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObservingEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public ViewObserver<String> attach(final ViewObserver.Ui ui) {
        return new ViewObserver<String>(ui) {
            @Override
            public void onChanged(@Nullable String s) {
                super.onChanged(s);

                setText(s);
            }
        };
    }
}