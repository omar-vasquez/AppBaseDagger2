package com.vasquez.omar.daggerboilerplate.utils;

import android.app.Fragment;

import com.vasquez.omar.daggerboilerplate.inject.PerChildFragment;
import com.vasquez.omar.daggerboilerplate.ui.common.view.BaseChildFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by jos_c on 23/03/2018.
 */

@PerChildFragment
public final class PerChildFragmentUtil {

    private final Fragment childFragment;

    @Inject
    PerChildFragmentUtil(@Named(BaseChildFragmentModule.CHILD_FRAGMENT) Fragment childFragment) {
        this.childFragment = childFragment;
    }

    public String doSomething() {
        return "PerChildFragmentUtil: " + hashCode()
                + ", child Fragment: " + childFragment.hashCode();
    }
}
