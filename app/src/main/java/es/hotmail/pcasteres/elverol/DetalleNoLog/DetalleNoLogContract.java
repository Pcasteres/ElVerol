package es.hotmail.pcasteres.elverol.DetalleNoLog;

import java.lang.ref.WeakReference;

interface DetalleNoLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(DetalleNoLogViewModel viewModel);
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

        void passDataToNextScreen(DetalleNoLogState state);

        DetalleNoLogState getDataFromPreviousScreen();
    }
}
