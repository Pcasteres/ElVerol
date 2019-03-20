package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class PrincipalLoginModel implements PrincipalLoginContract.Model {

    public static String TAG = PrincipalLoginModel.class.getSimpleName();

    public PrincipalLoginModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
