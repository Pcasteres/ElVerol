package es.hotmail.pcasteres.elverol.ListaProductosLog;

import android.util.Log;

import java.lang.ref.WeakReference;

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
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        ListaProductosLogState state = router.getDataFromPreviousScreen();
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
