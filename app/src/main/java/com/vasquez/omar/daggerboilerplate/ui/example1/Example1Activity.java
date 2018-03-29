package com.vasquez.omar.daggerboilerplate.ui.example1;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vasquez.omar.daggerboilerplate.R;
import com.vasquez.omar.daggerboilerplate.ui.common.BaseActivity;
import com.vasquez.omar.daggerboilerplate.ui.example1.view.Example1Fragment;

/**
 * Created by jos_c on 24/03/2018.
 */

public final class Example1Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_1_activity);

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new Example1Fragment());
        }
    }
}