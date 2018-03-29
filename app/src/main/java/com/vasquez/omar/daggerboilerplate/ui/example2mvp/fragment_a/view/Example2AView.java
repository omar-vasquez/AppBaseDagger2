package com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.view;

/**
 * Created by jos_c on 26/03/2018.
 */

import com.vasquez.omar.daggerboilerplate.ui.common.view.ViewMvpArquitecture;

/**
 * Una vista que contiene un botón que hace algo.
 */
public interface Example2AView extends ViewMvpArquitecture {

    void showSomething(String something);
}