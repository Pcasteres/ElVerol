package es.hotmail.pcasteres.elverol.Carrito;

import android.util.Log;

import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class CarritoModel implements CarritoContract.Model {

    public static String TAG = CarritoModel.class.getSimpleName();

    private RepositoryContract repository;

    public CarritoModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchData(
            int category, RepositoryContract.GetCarritoListCallback callback) {

        Log.e(TAG, "fetchProductListData()");
        repository.getcarritoList(category, callback);
    }
}
