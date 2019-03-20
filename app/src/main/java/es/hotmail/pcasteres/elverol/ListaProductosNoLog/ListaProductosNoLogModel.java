package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class ListaProductosNoLogModel implements ListaProductosNoLogContract.Model {

    public static String TAG = ListaProductosNoLogModel.class.getSimpleName();

    public ListaProductosNoLogModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
