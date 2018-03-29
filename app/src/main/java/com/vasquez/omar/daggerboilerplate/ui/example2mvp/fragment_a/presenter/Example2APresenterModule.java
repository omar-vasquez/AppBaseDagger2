package com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.presenter;

/**
 * Created by jos_c on 26/03/2018.
 */

import com.vasquez.omar.daggerboilerplate.inject.PerFragment;

import dagger.Binds;
import dagger.Module;

/**
 * Provides example 2 A presenter dependencies.
 */
@Module
public abstract class Example2APresenterModule {

    @Binds
    @PerFragment
    abstract Example2APresenter example2APresenter(Example2APresenterImpl example2APresenterImpl);

}