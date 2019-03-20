package es.hotmail.pcasteres.elverol.DetalleLog;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class DetalleLogModel implements DetalleLogContract.Model {

    public static String TAG = DetalleLogModel.class.getSimpleName();

    public DetalleLogModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
