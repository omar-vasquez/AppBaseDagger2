package com.vasquez.omar.daggerboilerplate;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by jos_c on 21/03/2018.
 */

/**
  * Android {@link Application}.
  * <p>
  * <b> INYECCIÓN DE DEPENDENCIA </ b>
  * Podríamos extender {@link dagger.android.DaggerApplication} para que podamos obtener el texto estándar
  * código de daga gratis. Sin embargo, queremos evitar la herencia (si es posible y es en este caso)
  * para que tengamos la opción de heredar de otra cosa más adelante si es necesario
  */
public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().create(this).inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
