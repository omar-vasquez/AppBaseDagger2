package com.vasquez.omar.daggerboilerplate.ui.main;

import android.app.Activity;

import com.vasquez.omar.daggerboilerplate.inject.PerActivity;
import com.vasquez.omar.daggerboilerplate.inject.PerFragment;
import com.vasquez.omar.daggerboilerplate.ui.common.BaseActivityModule;
import com.vasquez.omar.daggerboilerplate.ui.example1.view.Example1Fragment;
import com.vasquez.omar.daggerboilerplate.ui.example1.view.Example1FragmentModule;
import com.vasquez.omar.daggerboilerplate.ui.main.view.MainFragment;
import com.vasquez.omar.daggerboilerplate.ui.main.view.MainFragmentListener;
import com.vasquez.omar.daggerboilerplate.ui.main.view.MainFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jos_c on 23/03/2018.
 */

@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {
    /**
     * * Proporciona el inyector para {@link MainFragment}, que tiene acceso a las dependencias
       * proporcionado por esta actividad y instancia de aplicación (objetos de ámbito único)
     * @return
     */

    @PerFragment
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment mainFragmentInjector();


    /**
      * Según el contrato especificado en {@link BaseActivityModule}; "Esto debe incluirse en todos
      * módulos de actividad, que deben proporcionar una implementación concreta de {@link Activity}. "
      * <p>
      * Esto proporciona la actividad requerida para inyectar el
      * {@link BaseActivityModule # ACTIVITY_FRAGMENT_MANAGER} en el
      * @param mainActivity la actividad
      * @return la actividad
     */

    @Binds
    @PerActivity
    abstract Activity activity(MainActivity mainActivity);

    /**
     * La actividad principal escucha los eventos en {@link MainFragment}.
      *
      * @param mainActivity la actividad
      * @return el fragmento principal oyente
     */

    @Binds
    @PerActivity
    abstract MainFragmentListener mainFragmentListener(MainActivity mainActivity);

    //Proporcionar al inyector para que haga los diagolos del fragmento.
    @PerFragment
    @ContributesAndroidInjector(modules = Example1FragmentModule.class)
    abstract Example1Fragment example1FragmentInjector();
}