package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.util.Log;

import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class PrincipalLoginModel implements PrincipalLoginContract.Model {

    public static String TAG = PrincipalLoginModel.class.getSimpleName();

    private RepositoryContract repository;

    public PrincipalLoginModel(RepositoryContract repository) {
        this.repository = repository;

    }

    @Override
    public void fetchCategoryListData(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");
                    repository.getCategoryList(callback);

    }
    @Override
    public void fetchfacturaListData(
            final RepositoryContract.GetFacturaCallback callback) {

        Log.e(TAG, "fetchFacturaListData()");

                    repository.getFactura(1,callback);

    }
}
