package com.vasquez.omar.daggerboilerplate.ui.example2mvp;

import android.app.Activity;

import com.vasquez.omar.daggerboilerplate.inject.PerActivity;
import com.vasquez.omar.daggerboilerplate.inject.PerFragment;
import com.vasquez.omar.daggerboilerplate.ui.common.BaseActivityModule;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.view.Example2ActivityFragmentA;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.view.Example2FragmentModuleA;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_b.view.Example2ActivityFragmentB;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_b.view.Example2FragmentModuleB;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jos_c on 26/03/2018.
 */
@Module(includes = BaseActivityModule.class)
public abstract class Example2ActivityModule {


    @PerFragment
    @ContributesAndroidInjector(modules = Example2FragmentModuleA.class)
    abstract Example2ActivityFragmentA example2AFragmentInjector();

    /*
    @PerFragment
    @ContributesAndroidInjector(modules = Example2FragmentModuleB.class)
    abstract Example2ActivityFragmentB example2BFragmentInjector(); */

    @Binds
    @PerActivity
    abstract Activity activity(Example2Activity example2Activity);
}
