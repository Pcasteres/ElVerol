package es.hotmail.pcasteres.elverol.Carrito;

import android.util.Log;

import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class CarritoModel implements CarritoContract.Model {

    public static String TAG = CarritoModel.class.getSimpleName();

    private RepositoryContract repository;

    public CarritoModel(RepositoryContract repository){
        this.repository = repository;
    }

    @Override
    public void fetchData(FacturaItem facturaItem,
             RepositoryContract.GetCarritoListCallback callback) {

        Log.e(TAG, "fetchcarritoListData()");
        repository.getcarritoList(1, callback);
    }

    @Override
    public void fetchProductData(int in,
                                 RepositoryContract.GetProductDataCallback callback) {

        Log.e(TAG, "model.fetchProductData()");
        repository.getProductData(in, callback);
    }

    @Override
    public void fetchData2(int id,RepositoryContract.GetAllProductListCallback callback) {
        Log.e(TAG, "fetchcarritoListData()");
        repository.getAllProductList(id,callback);
    }

    @Override
    public void deleteCarrito(
            CarritoItem item, RepositoryContract.DeleteCarritoCallback callback){
        Log.e(TAG, "Deletecarrito()");
        repository.deleteCarrito(item, callback);

    }

    @Override
    public void updateproduct(ProductItem productItem, RepositoryContract.UpdateProductCallback callback) {
        Log.e(TAG, "updateproduct()");
        repository.updateProduct(productItem, callback);

    }

    @Override
    public void fetchfacturaListData(
            final RepositoryContract.GetFacturaCallback callback) {

        Log.e(TAG, "fetchFacturaListData()");

                    repository.getFactura(1,callback);

    }
}

