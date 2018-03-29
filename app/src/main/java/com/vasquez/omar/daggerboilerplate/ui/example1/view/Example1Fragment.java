package com.vasquez.omar.daggerboilerplate.ui.example1.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vasquez.omar.daggerboilerplate.R;
import com.vasquez.omar.daggerboilerplate.ui.common.view.BaseFragment;
import com.vasquez.omar.daggerboilerplate.utils.PerActivityUtil;
import com.vasquez.omar.daggerboilerplate.utils.PerFragmentUtil;
import com.vasquez.omar.daggerboilerplate.utils.SingletonUtil;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class Example1Fragment extends BaseFragment implements View.OnClickListener {

    @Inject
    SingletonUtil singletonUtil;

    @Inject
    PerActivityUtil perActivityUtil;

    @Inject
    PerFragmentUtil perFragmentUtil;

    private TextView someText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO (Butterknife) replace with butterknife view binding
        someText = (TextView) view.findViewById(R.id.some_text);
        view.findViewById(R.id.example1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.example1:
                onDoSomethingClicked();
                break;
            default:
                throw new IllegalArgumentException("Unhandled view " + view.getId());
        }
    }

    private void onDoSomethingClicked() {
        String something = singletonUtil.doSomething();
        something += "\n" + perActivityUtil.doSomething();
        something += "\n" + perFragmentUtil.doSomething();
        showSomething(something);
    }

    private void showSomething(String something) {
        someText.setText(something);
    }
}
