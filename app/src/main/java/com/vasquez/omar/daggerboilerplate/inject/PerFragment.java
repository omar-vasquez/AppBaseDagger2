package com.vasquez.omar.daggerboilerplate.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by jos_c on 21/03/2018.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}