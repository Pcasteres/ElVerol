package es.hotmail.pcasteres.elverol.ListaProductosLog;

import android.util.Log;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class ListaProductosLogModel implements ListaProductosLogContract.Model {

    public static String TAG = ListaProductosLogModel.class.getSimpleName();

    private RepositoryContract repository;

    public ListaProductosLogModel(RepositoryContract repository){
        this.repository = repository;
    }


    @Override
    public void fetchListaProductosLogData(
            CategoryItem category, RepositoryContract.GetProductListCallback callback) {

        Log.e(TAG, "fetchListaProductosLogData()");
        repository.getProductList(category, callback);
    }
}
