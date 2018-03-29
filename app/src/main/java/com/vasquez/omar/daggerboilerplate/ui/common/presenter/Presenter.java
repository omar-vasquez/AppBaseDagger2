package com.vasquez.omar.daggerboilerplate.ui.common.presenter;

/**
 * Created by jos_c on 26/03/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Un presentador que define sus propios métodos de ciclo de vida.
 */
public interface Presenter {

    /**
     * Comienza la presentación.
     * Esto debería llamarse en la vista (Actividad o Fragmento)
     * * método onCreate () o onViewStatedRestored () respectivamente.
     * *
     * * @param savedInstanceState el estado de la instancia guardada que contiene el estado guardado en
     * * {@link #onSaveInstanceState (Bundle)}
     */
    void onStart(@Nullable Bundle savedInstanceState);

    /**
     * Reanuda la presentación. Esto debería llamarse en la vista (Actividad o Fragmento)
     * método onResume ()

     */
    void onResume();

    /**
     * Pausa la presentación. Esto debería llamarse en la Actividad o Fragmento de la vista)
     * método onPause ()
     */
    void onPause();

    /**
     * Guarde el estado de la presentación (si corresponde). Esto debería llamarse en la vista
     * (Actividad o Fragmento) onSaveInstanceState ().
     * @param outState el estado de salida para guardar el estado de la instancia
     */
    void onSaveInstanceState(Bundle outState);

    /**
     * Finaliza la presentación. Esto debería llamarse en la vista (Actividad o Fragmento)
     * Método onDestroy () o onDestroyView () respectivamente.
     */
    void onEnd();
}