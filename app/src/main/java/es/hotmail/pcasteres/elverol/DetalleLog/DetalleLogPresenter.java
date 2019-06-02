package es.hotmail.pcasteres.elverol.DetalleLog;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class DetalleLogPresenter implements DetalleLogContract.Presenter {

    public static String TAG = DetalleLogPresenter.class.getSimpleName();

    private WeakReference<DetalleLogContract.View> view;
    private DetalleLogViewModel viewModel;
    private DetalleLogContract.Model model;
    private DetalleLogContract.Router router;

    public DetalleLogPresenter(DetalleLogState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<DetalleLogContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(DetalleLogContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(DetalleLogContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchDataProduct() {
        // Log.e(TAG, "fetchDataProduct()");

        // set passed state
        ProductItem product = router.getDataFromProductListScreen1();
        FacturaItem facturaItem = router.getDataFromProductListScreen2();

        viewModel.facturaItem = facturaItem;


        if (product != null) {
            if(viewModel.product==product){
                viewModel.cantidad=0;}
                if (viewModel.carritoItem==null){

                    viewModel.carritoItem=new CarritoItem();

                }
                fetchFacturaData();
                viewModel.carritoItem.idFactura=1;
                viewModel.carritoItem.idObjeto=product.id;
                viewModel.carritoItem.cantidad=viewModel.cantidad;
            //}
            viewModel.product = product;

        }
        view.get().displayProductDetailData(viewModel);

    }

    @Override
    public void fetchFacturaData() {
        // Log.e(TAG, "fetchFacturaData()");

        // call the model
        model.fetchfacturaListData(new RepositoryContract.GetFacturaCallback() {

            @Override
            public void setFactura(FacturaItem facturaItem) {
                viewModel.facturaItem = facturaItem;
            }
        });

    }

    @Override
    public void selectCarritoListData() {

        router.passDataToCarritoScreen(viewModel.facturaItem);
        router.navigateToCarritoScreen();

    }



    @Override
    public void reducircantidad()
    {
        if (viewModel.cantidad>0){

            viewModel.cantidad--;
            viewModel.carritoItem.cantidad=viewModel.cantidad;
        }
        view.get().displayProductDetailData(viewModel);
    }

    @Override
    public void aumentarcantidad()
    {

        if(viewModel.cantidad<viewModel.product.stock) {
            viewModel.cantidad++;
            viewModel.carritoItem.cantidad=viewModel.cantidad;
        }
        view.get().displayProductDetailData(viewModel);
    }

    @Override
    public void insertCarritoItem(){


            model.searchCarritoItem(viewModel.product.id, 1, new RepositoryContract.GetCarritoItemCallback() {
                @Override
                public void setCarritoItem(CarritoItem product) {

                    viewModel.carritoItem2=product;

                }
                });


            if (viewModel.carritoItem.cantidad==0){viewModel.carritoItem.cantidad=1;}
            if (viewModel.carritoItem2!=null){

                viewModel.carritoItem.cantidad=viewModel.carritoItem.cantidad+viewModel.carritoItem2.cantidad;
                viewModel.cantidad=viewModel.carritoItem.cantidad;
                model.updateCarritoItem(viewModel.carritoItem, new RepositoryContract.UpdateCarritoCallback() {
                    @Override
                    public void onCarritoUpdated() {
                        updateproductdata(viewModel.carritoItem.idObjeto);
                    }
                });

            }
            else {

               // viewModel.facturaItem.items.add(viewModel.carritoItem);
                model.insertCarritoItem(viewModel.carritoItem, new RepositoryContract.InsertCarritoCallback() {
                @Override
                public void onCarritoInsert() {
                    updateproductdata(viewModel.carritoItem.idObjeto);

                }

                });
            }
        view.get().displayProductDetailData(viewModel);

        router.passDataToCarritoScreen(viewModel.facturaItem);
        router.navigateToCarritoScreen();

    }


    @Override
    public void updateproductdata(final int idproduct){
        Log.e(TAG, String.valueOf(idproduct));

        fetchProductData(idproduct);


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
                        item.stock=item.stock-viewModel.cantidad;
                        Log.e(TAG, String.valueOf(item.stock));
                        model.updateproduct(item, new RepositoryContract.UpdateProductCallback() {
                            @Override
                            public void onProductUpdated() {

                            }
                        });
                    }

                });


    }

}
