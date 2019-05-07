package es.hotmail.pcasteres.elverol.Carrito;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.RepositoryContract;

interface CarritoContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(CarritoViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {

       // void fetchData(FacturaItem facturaItem, RepositoryContract.GetCarritoListCallback getCarritoListCallback);

        void fetchData(
                int category, RepositoryContract.GetCarritoListCallback callback);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(CarritoState state);

        int getDataFromPreviousScreen();
    }
}
