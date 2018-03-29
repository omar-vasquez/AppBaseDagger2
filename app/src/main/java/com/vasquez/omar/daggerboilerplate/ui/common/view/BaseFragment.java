package com.vasquez.omar.daggerboilerplate.ui.common.view;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import butterknife.Unbinder;


/**
 * Created by jos_c on 22/03/2018.
 */


public abstract class BaseFragment extends DialogFragment implements HasFragmentInjector {

    @Inject
    protected Context activityContext;

    // Note that this should not be used within a child fragment.
    @Inject
    @Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER)
    protected FragmentManager childFragmentManager;

    //ButterKnife

    @Nullable
    private Unbinder viewUnbinder;

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here before M, L (API 22) and below because onAttach(Context)
            // is not yet available at L.
            AndroidInjection.inject(this);
        }
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidInjection.inject(this);
        }
        super.onAttach(context);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        /*
         * Vincular las vistas aquí en lugar de en onViewCreated para que el estado de la vista cambie los oyentes
         * no se invocan automáticamente sin la interacción del usuario.
         *
         * Si vinculamos antes este método (por ejemplo, onViewCreated), cualquier marcada cambió
         * los oyentes atados por ButterKnife serán invocados durante la recreación de fragmentos (ya que
         * Android mismo guarda y restaura los estados de las vistas. Echa un vistazo a esta idea para un
         * ejemplo concreto: https://gist.github.com/vestrel00/982d585144423f728342787341fa001d
         *
         * El orden del ciclo de vida es el siguiente (lo mismo si se agrega a través de xml o java o si se conserva
                         * instancia es verdadera):
         *
         * enAtar
         * onCreateView
         * enViewCreated
         * onActivityCreated
         * onViewStateRestored
         * En resumen
         *
         * Tenga en cuenta que onCreate (y otros eventos del ciclo de vida) se omiten a propósito. los
         * advertencia a este enfoque es que las vistas, los oyentes y los recursos limitados por
         * Butterknife será nulo hasta que onViewStatedRestored. Solo ten cuidado de no usar
         * objetos enlazados usando Butterknife antes en ViewStateRestored.
         *
         * Fragmentos que no devuelven una vista no nula en resultados de onCreateView enViewCreated
         * y onViewStateRestored no se llama. Esto significa que Butterknife.bind no obtendrá
         * llamado, que está completamente bien porque no hay vista para enlazar. Además, hay
         * no es necesario verificar si getView () devuelve nulo aquí porque este método del ciclo de vida solo se obtiene
         * llamado con una vista no nula.
         */
        viewUnbinder = ButterKnife.bind(this, getView());
    }

    @Override
    public void onDestroyView() {
        // Este método de ciclo de vida aún se llama incluso si onCreateView devuelve una vista nula.
        if (viewUnbinder != null) {
            viewUnbinder.unbind();
        }
        super.onDestroyView();
    }


    @Override
    public final AndroidInjector<Fragment> fragmentInjector() {
        return childFragmentInjector;
    }

    protected final void addChildFragment(@IdRes int containerViewId, Fragment fragment) {
        childFragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }
}
