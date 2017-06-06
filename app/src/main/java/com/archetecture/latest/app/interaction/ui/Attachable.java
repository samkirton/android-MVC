package com.archetecture.latest.app.interaction.ui;

import android.arch.lifecycle.Observer;

public interface Attachable<T> {

    Observer<T> attach();
}