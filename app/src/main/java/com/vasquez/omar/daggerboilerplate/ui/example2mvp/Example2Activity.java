package com.vasquez.omar.daggerboilerplate.ui.example2mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.vasquez.omar.daggerboilerplate.R;
import com.vasquez.omar.daggerboilerplate.ui.common.BaseActivity;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_a.view.Example2ActivityFragmentA;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_b.view.Example2ActivityFragmentB;

public class Example2Activity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_content2, new Example2ActivityFragmentA());
        }
    }

}
