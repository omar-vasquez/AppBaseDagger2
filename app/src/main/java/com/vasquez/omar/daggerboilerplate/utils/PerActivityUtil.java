package com.vasquez.omar.daggerboilerplate.utils;

import android.app.Activity;

import com.vasquez.omar.daggerboilerplate.inject.PerActivity;

import javax.inject.Inject;

/**
 * Created by jos_c on 23/03/2018.
 */

@PerActivity
public final class PerActivityUtil {

    private final Activity activity;

    @Inject
    PerActivityUtil(Activity activity) {
        this.activity = activity;
    }

    public String doSomething() {
        return "PerActivityUtil: " + hashCode() + ", Activity: " + activity.hashCode();
    }
}