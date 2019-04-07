package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import java.lang.ref.WeakReference;
import java.util.List;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

public class ListaProductosNoLogPresenter implements ListaProductosNoLogContract.Presenter {

    public static String TAG = ListaProductosNoLogPresenter.class.getSimpleName();

    private WeakReference<ListaProductosNoLogContract.View> view;
    private ListaProductosNoLogViewModel viewModel;
    private ListaProductosNoLogContract.Model model;
    private ListaProductosNoLogContract.Router router;

    public ListaProductosNoLogPresenter(ListaProductosNoLogState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ListaProductosNoLogContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ListaProductosNoLogContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ListaProductosNoLogContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchListaProductosNoLogData() {
        // Log.e(TAG, "fetchProductListData()");

        // set passed state
        CategoryItem item = router.getDataFromPrincipalNoLog();

        if (item != null) {
            viewModel.category = item;
        }

        // call the model
        model.fetchListaProductosNoLogData(viewModel.category,
                new RepositoryContract.GetProductListCallback() {

                    @Override
                    public void setProductList(List<ProductItem> products) {
                        viewModel.products = products;

                        view.get().displayListaProductosNoLogData(viewModel);
                    }
                });

    }


    @Override
    public void selectProductListData(ProductItem item) {
        router.passDataToNextScreen(item);
        router.navigateToNextScreen();
    }


}
