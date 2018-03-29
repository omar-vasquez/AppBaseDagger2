package com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.presenter;

import com.vasquez.omar.daggerboilerplate.inject.PerFragment;
import com.vasquez.omar.daggerboilerplate.ui.common.presenter.BasePresenter;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.view.Example2AView;
import com.vasquez.omar.daggerboilerplate.utils.PerActivityUtil;
import com.vasquez.omar.daggerboilerplate.utils.PerFragmentUtil;
import com.vasquez.omar.daggerboilerplate.utils.SingletonUtil;

import javax.inject.Inject;

/**
 * Created by jos_c on 26/03/2018.
 */

@PerFragment
final class Example2APresenterImpl extends BasePresenter<Example2AView>
        implements Example2APresenter {

    private final SingletonUtil singletonUtil;
    private final PerActivityUtil perActivityUtil;
    private final PerFragmentUtil perFragmentUtil;

    @Inject
    Example2APresenterImpl(Example2AView view, SingletonUtil singletonUtil,
                           PerActivityUtil perActivityUtil, PerFragmentUtil perFragmentUtil) {
        super(view);
        this.singletonUtil = singletonUtil;
        this.perActivityUtil = perActivityUtil;
        this.perFragmentUtil = perFragmentUtil;
    }

    @Override
    public void onDoSomething() {
        // Do something here. Maybe make an asynchronous call to fetch data...
        String something = singletonUtil.doSomething();
        something += "\n" + perActivityUtil.doSomething();
        something += "\n" + perFragmentUtil.doSomething();
        view.showSomething(something);
    }
}
