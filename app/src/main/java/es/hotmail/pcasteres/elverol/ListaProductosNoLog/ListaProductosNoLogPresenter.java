package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import android.util.Log;

import java.lang.ref.WeakReference;

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
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        ListaProductosNoLogState state = router.getDataFromPreviousScreen();
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
