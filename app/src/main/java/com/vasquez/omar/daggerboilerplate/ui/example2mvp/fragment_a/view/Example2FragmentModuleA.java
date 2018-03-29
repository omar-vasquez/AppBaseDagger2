package com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.view;

import android.app.Fragment;

import com.vasquez.omar.daggerboilerplate.inject.PerFragment;
import com.vasquez.omar.daggerboilerplate.ui.common.view.BaseFragmentModule;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.presenter.Example2APresenterModule;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_b.view.Example2ActivityFragmentB;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by jos_c on 26/03/2018.
 */

@Module(includes = {
        BaseFragmentModule.class,
        Example2APresenterModule.class
})

public abstract class Example2FragmentModuleA {
     /**
      * Según el contrato especificado en {@link BaseFragmentModule};
      * "Esto debe incluirse en todos módulos de fragmentos,
      * que deben proporcionar una implementación concreta
      * de {@link Fragment}
      * y llamado {@link BaseFragmentModule # FRAGMENT}.      *
      * @param example2AFragment el ejemplo 2 Un fragmento      * @return the fragment
     */
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(Example2ActivityFragmentA example2AFragment);

    @Binds
    @PerFragment
    abstract Example2AView example2AView(Example2ActivityFragmentA example2AFragment);
}
