package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.util.Log;

import java.lang.ref.WeakReference;

public class PrincipalLoginPresenter implements PrincipalLoginContract.Presenter {

    public static String TAG = PrincipalLoginPresenter.class.getSimpleName();

    private WeakReference<PrincipalLoginContract.View> view;
    private PrincipalLoginViewModel viewModel;
    private PrincipalLoginContract.Model model;
    private PrincipalLoginContract.Router router;

    public PrincipalLoginPresenter(PrincipalLoginState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PrincipalLoginContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PrincipalLoginContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PrincipalLoginContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        PrincipalLoginState state = router.getDataFromPreviousScreen();
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
