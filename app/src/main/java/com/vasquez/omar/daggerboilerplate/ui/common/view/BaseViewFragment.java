package com.vasquez.omar.daggerboilerplate.ui.common.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import com.vasquez.omar.daggerboilerplate.ui.common.presenter.Presenter;

import javax.inject.Inject;

/**
 * Created by jos_c on 26/03/2018.
 * Un {@link BaseFragment} que contiene e invoca invocaciones de ciclo de vida de {@link Presenter}.
 *
 * @param <T> el tipo de {@link Presenter}.
 */

public abstract class BaseViewFragment<T extends Presenter> extends BaseFragment
        implements ViewMvpArquitecture {

    @Inject
    protected T presenter;

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        // Solo inicie el presentador cuando las vistas hayan sido enlazadas.
        // Ver BaseFragment.onViewStateRestored
        presenter.onStart(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        presenter.onEnd();
        super.onDestroyView();
    }
}