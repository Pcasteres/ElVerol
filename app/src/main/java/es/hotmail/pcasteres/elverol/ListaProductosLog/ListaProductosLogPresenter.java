package es.hotmail.pcasteres.elverol.ListaProductosLog;

import java.lang.ref.WeakReference;
import java.util.List;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class ListaProductosLogPresenter implements ListaProductosLogContract.Presenter {

    public static String TAG = ListaProductosLogPresenter.class.getSimpleName();

    private WeakReference<ListaProductosLogContract.View> view;
    private ListaProductosLogViewModel viewModel;
    private ListaProductosLogContract.Model model;
    private ListaProductosLogContract.Router router;

    public ListaProductosLogPresenter(ListaProductosLogState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ListaProductosLogContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ListaProductosLogContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ListaProductosLogContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchListaProductosLogData() {
        // Log.e(TAG, "fetchProductListData()");

        // set passed state
        CategoryItem item = router.getDataFromPrincipalLog();

        if (item != null) {
            viewModel.category = item;
        }

        // call the model
        model.fetchListaProductosLogData(viewModel.category,
                new RepositoryContract.GetProductListCallback() {

                    @Override
                    public void setProductList(List<ProductItem> products) {
                        viewModel.products = products;

                        view.get().displayListaProductosLogData(viewModel);
                    }
                });

    }


    @Override
    public void selectProductListData(ProductItem item) {
        router.passDataToDetalleLogActivity(item,viewModel.facturaItem);
        router.navigateToDetalleLogScreen();
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
    public void selectCarritoListData(){

        router.passDataToCarritoScreen(viewModel.facturaItem);
        router.navigateToCarritoScreen();

    }
}
