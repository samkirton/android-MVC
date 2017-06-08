package com.memtrip.mvmp.presenter.interaction.ui;

public interface ViewObservable<T> {

    ViewObserver<T> attach(final ViewObserver.Ui ui);
}