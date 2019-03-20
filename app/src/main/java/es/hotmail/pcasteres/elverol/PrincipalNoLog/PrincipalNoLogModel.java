package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class PrincipalNoLogModel implements PrincipalNoLogContract.Model {

    public static String TAG = PrincipalNoLogModel.class.getSimpleName();

    public PrincipalNoLogModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
