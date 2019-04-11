package es.hotmail.pcasteres.elverol.DetalleLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.ProductItem;

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
        ProductItem product = router.getDataFromProductListScreen();
        if(product != null) {
            viewModel.product = product;
        }
        view.get().displayProductDetailData(viewModel);

    }

}
