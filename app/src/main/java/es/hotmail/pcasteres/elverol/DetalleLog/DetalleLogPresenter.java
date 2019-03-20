package es.hotmail.pcasteres.elverol.DetalleLog;

import android.util.Log;

import java.lang.ref.WeakReference;

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
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        DetalleLogState state = router.getDataFromPreviousScreen();
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
