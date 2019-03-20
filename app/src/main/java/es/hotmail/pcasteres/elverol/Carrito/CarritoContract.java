package es.hotmail.pcasteres.elverol.Carrito;

import java.lang.ref.WeakReference;

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
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(CarritoState state);

        CarritoState getDataFromPreviousScreen();
    }
}
