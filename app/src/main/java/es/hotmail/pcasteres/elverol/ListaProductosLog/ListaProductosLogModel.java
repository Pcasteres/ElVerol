package es.hotmail.pcasteres.elverol.ListaProductosLog;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class ListaProductosLogModel implements ListaProductosLogContract.Model {

    public static String TAG = ListaProductosLogModel.class.getSimpleName();

    public ListaProductosLogModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
