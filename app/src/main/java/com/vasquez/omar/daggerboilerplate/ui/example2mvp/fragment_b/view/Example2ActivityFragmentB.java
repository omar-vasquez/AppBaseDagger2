package com.vasquez.omar.daggerboilerplate.ui.example2mvp.fragment_b.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vasquez.omar.daggerboilerplate.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Example2ActivityFragmentB extends Fragment {

    public Example2ActivityFragmentB() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example2, container, false);
    }
}
