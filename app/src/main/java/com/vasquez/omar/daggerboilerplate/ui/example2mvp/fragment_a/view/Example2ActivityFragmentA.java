package com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vasquez.omar.daggerboilerplate.R;
import com.vasquez.omar.daggerboilerplate.ui.common.view.BaseViewFragment;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.presenter.Example2APresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class Example2ActivityFragmentA extends BaseViewFragment<Example2APresenter>
            implements Example2AView{

    @BindView(R.id.some_text)
    TextView someText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example1, container, false);
    }

    @Override
    public void showSomething(String something) {
        someText.setText(something);
    }

    @OnClick(R.id.example1)
    void onDoSomethingClicked() {
        presenter.onDoSomething();
    }
}
