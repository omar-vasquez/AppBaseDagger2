package com.vasquez.omar.daggerboilerplate.ui.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vasquez.omar.daggerboilerplate.R;
import com.vasquez.omar.daggerboilerplate.ui.common.view.BaseFragment;

import javax.inject.Inject;


/**
 * Created by jos_c on 23/03/2018.
 */

public final class MainFragment extends BaseFragment implements View.OnClickListener {

   @Inject
   MainFragmentListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TODO (Butterknife) replace with butterknife view binding
        view.findViewById(R.id.boton1).setOnClickListener(this);
        view.findViewById(R.id.boton2).setOnClickListener(this);
        view.findViewById(R.id.boton3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton1:
                onExample1Clicked();
                break;
            case R.id.boton2:
                onExample2Clicked();
                break;
            case R.id.boton3:
                onExample3Clicked();
                break;
            default:
                throw new IllegalArgumentException("Unhandled view " + view.getId());
        }
    }

    private void onExample1Clicked() {
        listener.onExample1Clicked();
    }

    private void onExample2Clicked() {
        listener.onExample2Clicked();
    }

    private void onExample3Clicked() {
        listener.onExample3Clicked();
    }
}
