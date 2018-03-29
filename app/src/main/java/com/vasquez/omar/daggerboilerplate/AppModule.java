package com.vasquez.omar.daggerboilerplate;

import android.app.Application;

import com.vasquez.omar.daggerboilerplate.inject.PerActivity;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.Example2Activity;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.Example2ActivityModule;
import com.vasquez.omar.daggerboilerplate.ui.main.MainActivity;
import com.vasquez.omar.daggerboilerplate.ui.main.MainActivityModule;
import com.vasquez.omar.daggerboilerplate.ui.example1.Example1Activity;
import com.vasquez.omar.daggerboilerplate.ui.example1.Example1ActivityModule;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jos_c on 21/03/2018.
 */
@Module(includes = AndroidInjectionModule.class)
abstract class AppModule {

    @Binds
    @Singleton
    /*
      * La anotación singleton no es necesaria ya que la instancia de la aplicación es única, pero está aquí para
      * convención. En general, proporcionar Activity, Fragment, BroadcastReceiver, etc. no requiere
      * para que tengan un alcance, ya que son los componentes que se inyectan y su instancia es única.
      *
      * Sin embargo, tener una anotación de alcance hace que el módulo sea más fácil de leer. No tendríamos que mirar
      * a lo que se proporciona para comprender su alcance.
    */
    abstract Application application(App app);

    /**
     * Proporciona el inyector para {@link MainActivity}, que tiene acceso a las dependencias
     * proporcionado por esta instancia de aplicación (objetos de ámbito singleton).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = Example1ActivityModule.class)
    abstract Example1Activity example1ActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = Example2ActivityModule.class)
    abstract Example2Activity example2ActivityInjector();
}



