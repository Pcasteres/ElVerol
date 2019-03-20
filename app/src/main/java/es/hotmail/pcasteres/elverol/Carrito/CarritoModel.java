package es.hotmail.pcasteres.elverol.Carrito;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class CarritoModel implements CarritoContract.Model {

    public static String TAG = CarritoModel.class.getSimpleName();

    public CarritoModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
