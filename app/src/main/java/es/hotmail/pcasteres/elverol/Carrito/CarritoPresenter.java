package es.hotmail.pcasteres.elverol.Carrito;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.MinProductItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class CarritoPresenter implements CarritoContract.Presenter {

    public static String TAG = CarritoPresenter.class.getSimpleName();

    private WeakReference<CarritoContract.View> view;
    private CarritoViewModel viewModel;
    private CarritoContract.Model model;
    private CarritoContract.Router router;
    public String name="";
    public ProductItem itemmm;
    public CarritoPresenter(CarritoState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<CarritoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CarritoContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(CarritoContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
         Log.e(TAG, "fetchData()");

        // set passed state
        Log.e(TAG, "fetchcarritopresenter()");
        FacturaItem item = router.getDataFromPreviousScreen();

        if (item != null) {
            viewModel.facturaItem = item;
        }

        // call the model
        model.fetchData(viewModel.facturaItem,
                new RepositoryContract.GetCarritoListCallback() {

                    @Override
                    public void setCarritoList(List<CarritoItem> products) {
                        if (viewModel.Carritoo != null) {
                            viewModel.Carritoo.clear();
                        }
                        if (viewModel.productss!= null) {
                            viewModel.productss.clear();
                        }

                        viewModel.Carritoo = products;

                        model.fetchData2(viewModel.facturaItem.id, new RepositoryContract.GetAllProductListCallback() {

                            @Override
                            public void setAllProductList(List<MinProductItem> products) {
                                viewModel.productss = products;
                            }

                        });
                        view.get().displayData(viewModel);
                    }
                });

    }


    @Override
    public void fetchFacturaData() {
         Log.e(TAG, "fetchFacturaData()");

        // call the model
        model.fetchfacturaListData(new RepositoryContract.GetFacturaCallback() {

            @Override
            public void setFactura(FacturaItem facturaItem) {
                viewModel.facturaItem = facturaItem;

            }
        });

    }

    @Override
    public void fetchProductData(int in) {
        // Log.e(TAG, "fetchNameData()");

        // set passed state
        Log.e(TAG, "fetchProductData()");


        // call the model
        model.fetchProductData(in,
                new RepositoryContract.GetProductDataCallback() {

                    @Override
                    public void setProductData(ProductItem item) {

                        Log.e(TAG, String.valueOf(item.stock));
                        Log.e(TAG, String.valueOf(viewModel.cantidad));
                        item.stock=item.stock+viewModel.cantidad;
                        Log.e(TAG, String.valueOf(item.stock));
                        model.updateproduct(item, new RepositoryContract.UpdateProductCallback() {
                            @Override
                            public void onProductUpdated() {

                            }
                        });
                    }

                });



    }

    @Override
    public void deleteCarritoItem(final CarritoItem itemm){
        Log.e(TAG, "deletecarritoitem");
            viewModel.cantidad=itemm.cantidad;
            model.deleteCarrito(itemm, new RepositoryContract.DeleteCarritoCallback() {
                @Override
                public void onCarritoDeleted() {
                    updateproductdata(itemm.idObjeto);
                    fetchFacturaData();
                    fetchData();
                }
            });


    }


    @Override
    public void updateproductdata(final int idproduct){
        Log.e(TAG, "updateproductdata");
        Log.e(TAG, String.valueOf(idproduct));

        fetchProductData(idproduct);


    }

}
