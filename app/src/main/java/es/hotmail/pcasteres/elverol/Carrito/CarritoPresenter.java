package es.hotmail.pcasteres.elverol.Carrito;

import java.lang.ref.WeakReference;
import java.util.List;

import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

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
        int userid = router.getDataFromPreviousScreen();

        if (userid != 0) {
            viewModel.userid = userid;
        }

        // call the model
        model.fetchData(viewModel.userid,
                new RepositoryContract.GetCarritoListCallback() {

                    @Override
                    public void setCarritoList(List<CarritoItem> products) {
                        viewModel.Carritoo = products;

                        view.get().displayData(viewModel);
                    }
                });

    }


}
