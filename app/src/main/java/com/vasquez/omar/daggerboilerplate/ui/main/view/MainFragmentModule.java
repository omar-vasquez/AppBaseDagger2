package com.vasquez.omar.daggerboilerplate.ui.main.view;

import android.app.Fragment;

import com.vasquez.omar.daggerboilerplate.inject.PerFragment;
import com.vasquez.omar.daggerboilerplate.ui.common.view.BaseFragmentModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by jos_c on 23/03/2018.
 */

@Module(includes = BaseFragmentModule.class)
public abstract class MainFragmentModule {
    /**
       * Según el contrato especificado en {@link BaseFragmentModule}; "Esto debe incluirse en todos
       * módulos de fragmentos, que deben proporcionar una implementación concreta de {@link Fragment}
       * y llamado {@link BaseFragmentModule # FRAGMENT}.
       *
       * @param mainFragment el fragmento principal
       * @return the fragment
     */
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(MainFragment mainFragment);
}
