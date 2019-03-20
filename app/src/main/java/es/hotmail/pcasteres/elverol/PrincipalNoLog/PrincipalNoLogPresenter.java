package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.util.Log;

import java.lang.ref.WeakReference;

public class PrincipalNoLogPresenter implements PrincipalNoLogContract.Presenter {

    public static String TAG = PrincipalNoLogPresenter.class.getSimpleName();

    private WeakReference<PrincipalNoLogContract.View> view;
    private PrincipalNoLogViewModel viewModel;
    private PrincipalNoLogContract.Model model;
    private PrincipalNoLogContract.Router router;

    public PrincipalNoLogPresenter(PrincipalNoLogState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PrincipalNoLogContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PrincipalNoLogContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PrincipalNoLogContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        PrincipalNoLogState state = router.getDataFromPreviousScreen();
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
