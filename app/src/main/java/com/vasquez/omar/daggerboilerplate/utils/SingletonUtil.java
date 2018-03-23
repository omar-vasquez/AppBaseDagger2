package com.vasquez.omar.daggerboilerplate.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jos_c on 23/03/2018.
 */

@Singleton
public final class SingletonUtil {

    @Inject
    SingletonUtil() {
    }

    public String doSomething() {
        return "SingletonUtil: " + hashCode();
    }
}