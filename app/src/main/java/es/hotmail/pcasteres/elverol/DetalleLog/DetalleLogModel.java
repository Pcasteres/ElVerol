package es.hotmail.pcasteres.elverol.DetalleLog;

import android.util.Log;

import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class DetalleLogModel implements DetalleLogContract.Model {

    public static String TAG = DetalleLogModel.class.getSimpleName();

    private RepositoryContract repository;

    public DetalleLogModel(RepositoryContract repository){
        this.repository = repository;
    }


    @Override
    public void fetchfacturaListData(
            final RepositoryContract.GetFacturaCallback callback) {

        Log.e(TAG, "fetchFacturaListData()");

        repository.getFactura(1, callback);
        }

    @Override
    public void insertCarritoItem(
            CarritoItem item, RepositoryContract.InsertCarritoCallback callback){
        Log.e(TAG, "InsertCarrito()");
        repository.insertCarrito(item, callback);

    }

    @Override
    public void updateCarritoItem(
            CarritoItem item, RepositoryContract.UpdateCarritoCallback callback){
        Log.e(TAG, "UpdateCarrito()");
        repository.updateCarrito(item, callback);

    }

    @Override
    public void searchCarritoItem(int id, int fac,
            final RepositoryContract.GetCarritoItemCallback callback) {

        Log.e(TAG, "fetchFacturaListData()");

        repository.getcarritoItem(id ,fac , callback);
    }

    @Override
    public void updateproduct(ProductItem productItem, RepositoryContract.UpdateProductCallback callback) {
        Log.e(TAG, "updateproduct()");
        repository.updateProduct(productItem, callback);

    }

    @Override
    public void fetchProductData(int in,
                                 RepositoryContract.GetProductDataCallback callback) {

        Log.e(TAG, "model.fetchProductData()");
        repository.getProductData(in, callback);
    }
}
