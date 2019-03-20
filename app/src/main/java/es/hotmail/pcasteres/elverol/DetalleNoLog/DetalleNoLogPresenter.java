package es.hotmail.pcasteres.elverol.DetalleNoLog;

import android.util.Log;

import java.lang.ref.WeakReference;

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
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        DetalleNoLogState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayData(viewModel);

    }


}
