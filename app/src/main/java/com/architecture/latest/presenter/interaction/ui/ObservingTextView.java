package com.architecture.latest.presenter.interaction.ui;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.architecture.latest.presenter.interaction.model.res.StringResData;

public class ObservingTextView extends AppCompatTextView implements ViewObservable<StringResData> {

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
    public Observer<StringResData> attach(final Ui ui) {
        return new Observer<StringResData>() {
            @Override
            public void onChanged(@Nullable StringResData s) {
                if (s != null) {
                    setVisibility(View.VISIBLE);
                    setText(getResources().getString(s.id()));
                }

                if (ui != null)  {
                    ui.present();
                }
            }
        };
    }
}