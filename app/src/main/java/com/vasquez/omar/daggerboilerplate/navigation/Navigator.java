package com.vasquez.omar.daggerboilerplate.navigation;

import android.content.Context;
import android.content.Intent;

import com.vasquez.omar.daggerboilerplate.ui.example1.Example1Activity;
import com.vasquez.omar.daggerboilerplate.ui.example2mvp.Example2Activity;
import com.vasquez.omar.daggerboilerplate.ui.main.MainActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jos_c on 26/03/2018.
 */

@Singleton
public final class Navigator {

    @Inject
    Navigator() {}

    public void toExample1(Context context) {
        Intent intent = new Intent(context, Example1Activity.class);
        context.startActivity(intent);
    }

    public void toExample2(Context context) {
        Intent intent = new Intent(context, Example2Activity.class);
        context.startActivity(intent);
    }
}
