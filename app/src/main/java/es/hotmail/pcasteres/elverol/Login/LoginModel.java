package es.hotmail.pcasteres.elverol.Login;

import android.util.Log;

import es.hotmail.pcasteres.elverol.ListaProductosLog.ListaProductosLogModel;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class LoginModel implements LoginContract.Model {

    public static String TAG = ListaProductosLogModel.class.getSimpleName();

    private RepositoryContract repository;

    public LoginModel(RepositoryContract repository){
        this.repository = repository;
    }
    @Override
    public void fetchLoginData(
            String user, String pass, RepositoryContract.GetUserCallback callback) {

        Log.e(TAG, "fetchLoginData()");
        repository.getUser(user, pass, callback);
    }

    public String fetchData(){
        return null;
    }



}
