package es.hotmail.pcasteres.elverol.NewUser;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class NewUserModel implements NewUserContract.Model {

    public static String TAG = NewUserModel.class.getSimpleName();

    public NewUserModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
