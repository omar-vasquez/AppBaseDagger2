package com.vasquez.omar.daggerboilerplate;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Created by jos_c on 21/03/2018.
 */

@Singleton
@Component(modules = AppModule.class)
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}