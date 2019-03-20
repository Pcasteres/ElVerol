package es.hotmail.pcasteres.elverol.DetalleNoLog;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class DetalleNoLogModel implements DetalleNoLogContract.Model {

    public static String TAG = DetalleNoLogModel.class.getSimpleName();

    public DetalleNoLogModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
