package com.memtrip.mvmp.presenter.interaction.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.memtrip.mvmp.presenter.interaction.model.res.StringResData;

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
    public ViewObserver<StringResData> attach(final ViewObserver.Ui ui) {
        return new ViewObserver<StringResData>(ui) {
            @Override
            public void onChanged(@Nullable StringResData s) {
                super.onChanged(s);

                if (s != null) {
                    setVisibility(View.VISIBLE);
                    setText(getResources().getString(s.id()));
                }
            }
        };
    }
}