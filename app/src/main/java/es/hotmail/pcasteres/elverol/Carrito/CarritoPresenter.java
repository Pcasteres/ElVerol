package es.hotmail.pcasteres.elverol.Carrito;

import android.util.Log;

import java.lang.ref.WeakReference;

public class CarritoPresenter implements CarritoContract.Presenter {

    public static String TAG = CarritoPresenter.class.getSimpleName();

    private WeakReference<CarritoContract.View> view;
    private CarritoViewModel viewModel;
    private CarritoContract.Model model;
    private CarritoContract.Router router;

    public CarritoPresenter(CarritoState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<CarritoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CarritoContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(CarritoContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        CarritoState state = router.getDataFromPreviousScreen();
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
