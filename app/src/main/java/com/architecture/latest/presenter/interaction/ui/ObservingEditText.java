package com.architecture.latest.presenter.interaction.ui;

import android.arch.lifecycle.Observer;
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
    public Observer<String> attach(final Ui ui) {
        return new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                setText(s);

                if (ui != null)  {
                    ui.present();
                }
            }
        };
    }
}