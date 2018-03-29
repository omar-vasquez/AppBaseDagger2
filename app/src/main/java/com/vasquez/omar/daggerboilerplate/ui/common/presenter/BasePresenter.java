package com.vasquez.omar.daggerboilerplate.ui.common.presenter;

/**
 * Created by jos_c on 26/03/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vasquez.omar.daggerboilerplate.ui.common.view.ViewMvpArquitecture;

/**
 * Resumen {@link Presenter} para que se extiendan todos los presentadores.
 *
 * @param <T> the type of the {@link ViewMvpArquitecture}.
 */
public abstract class BasePresenter<T extends ViewMvpArquitecture> implements Presenter {

    protected final T view;

    protected BasePresenter(T view) {
        this.view = view;
    }

    @Override
    public void onStart(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void onEnd() {
    }
}