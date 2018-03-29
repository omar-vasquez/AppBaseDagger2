package com.vasquez.omar.daggerboilerplate.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.vasquez.omar.daggerboilerplate.R;
import com.vasquez.omar.daggerboilerplate.ui.common.BaseActivity;
import com.vasquez.omar.daggerboilerplate.ui.example1.view.Example1Fragment;
import com.vasquez.omar.daggerboilerplate.ui.main.view.MainFragment;
import com.vasquez.omar.daggerboilerplate.ui.main.view.MainFragmentListener;


/**
 * Created by jos_c on 23/03/2018.
 */


public final class MainActivity extends BaseActivity implements MainFragmentListener {

    private String TAG_EXAMPLE_1 ="MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new MainFragment());
        }
    }

    @Override
    public void onExample1Clicked() {
        // TODO start example 1 activity
        navigator.toExample1(this);
        //Toast.makeText(this, "Launch example 1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onExample2Clicked() {
        // TODO start example 2 activity
        showDialogFragment(new Example1Fragment(), TAG_EXAMPLE_1);
        // Toast.makeText(this, "Launch example 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onExample3Clicked() {
        // TODO start example 3 activity

       navigator.toExample2(this);
       // Toast.makeText(this, "Launch example 3", Toast.LENGTH_SHORT).show();
    }
}