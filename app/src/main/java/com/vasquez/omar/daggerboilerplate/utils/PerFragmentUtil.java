package com.vasquez.omar.daggerboilerplate.utils;

import android.app.Fragment;

import com.vasquez.omar.daggerboilerplate.inject.PerFragment;
import com.vasquez.omar.daggerboilerplate.ui.common.view.BaseFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by jos_c on 23/03/2018.
 */

@PerFragment
public final class PerFragmentUtil {

    private final Fragment fragment;

    @Inject
    PerFragmentUtil(@Named(BaseFragmentModule.FRAGMENT) Fragment fragment) {
        this.fragment = fragment;
    }

    public String doSomething() {
        return "PerFragmentUtil: " + hashCode() + ", Fragment: " + fragment.hashCode();
    }
}