package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import android.util.Log;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;


public class ListaProductosNoLogModel implements ListaProductosNoLogContract.Model {

    public static String TAG = ListaProductosNoLogModel.class.getSimpleName();


    private RepositoryContract repository;

    public ListaProductosNoLogModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchListaProductosNoLogData(
            CategoryItem category, RepositoryContract.GetProductListCallback callback) {

        Log.e(TAG, "fetchListaProductosNoLogData()");
        repository.getProductList(category, callback);
    }

}