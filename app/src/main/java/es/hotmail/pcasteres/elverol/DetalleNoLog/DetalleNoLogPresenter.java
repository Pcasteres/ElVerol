package es.hotmail.pcasteres.elverol.DetalleNoLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.ProductItem;

public class DetalleNoLogPresenter implements DetalleNoLogContract.Presenter {

    public static String TAG = DetalleNoLogPresenter.class.getSimpleName();

    private WeakReference<DetalleNoLogContract.View> view;
    private DetalleNoLogViewModel viewModel;
    private DetalleNoLogContract.Model model;
    private DetalleNoLogContract.Router router;

    public DetalleNoLogPresenter(DetalleNoLogState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<DetalleNoLogContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(DetalleNoLogContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(DetalleNoLogContract.Router router) {
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

    @Override
    public void goToLoginScreen(){

        router.navigateToLoginScreen();

    }

}
