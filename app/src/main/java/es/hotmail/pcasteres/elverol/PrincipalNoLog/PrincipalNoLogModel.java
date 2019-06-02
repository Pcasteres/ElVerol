package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.util.Log;

import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class PrincipalNoLogModel implements PrincipalNoLogContract.Model {

    public static String TAG = PrincipalNoLogModel.class.getSimpleName();

    private RepositoryContract repository;

    public PrincipalNoLogModel(RepositoryContract repository) {
        this.repository = repository;

    }


    @Override
    public void fetchCategoryListData(
            final RepositoryContract.GetCategoryListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");

        repository.loadCatalog(true, new RepositoryContract.FetchCatalogDataCallback() {

            @Override
            public void onCatalogDataFetched(boolean error) {
                if(!error) {
                    repository.getCategoryList(callback);
                }
            }
        });

    }

}
