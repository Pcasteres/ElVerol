package es.hotmail.pcasteres.elverol.DetalleLog;

import java.lang.ref.WeakReference;

interface DetalleLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(DetalleLogViewModel viewModel);
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

        void passDataToNextScreen(DetalleLogState state);

        DetalleLogState getDataFromPreviousScreen();
    }
}
