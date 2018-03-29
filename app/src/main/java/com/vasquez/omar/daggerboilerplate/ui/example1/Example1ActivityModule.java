package com.vasquez.omar.daggerboilerplate.ui.example1;

import android.app.Activity;

import com.vasquez.omar.daggerboilerplate.inject.PerActivity;
import com.vasquez.omar.daggerboilerplate.inject.PerFragment;
import com.vasquez.omar.daggerboilerplate.ui.common.BaseActivityModule;
import com.vasquez.omar.daggerboilerplate.ui.example1.view.Example1Fragment;
import com.vasquez.omar.daggerboilerplate.ui.example1.view.Example1FragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jos_c on 24/03/2018.
 */

@Module(includes = BaseActivityModule.class)
public abstract class Example1ActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = Example1FragmentModule.class)
    abstract Example1Fragment examplete1FragmentInjector();

    @Binds
    @PerActivity
    abstract Activity activity(Example1Activity example1Activity);
}
