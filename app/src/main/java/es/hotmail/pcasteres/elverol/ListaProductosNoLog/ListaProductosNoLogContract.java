package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import java.lang.ref.WeakReference;

interface ListaProductosNoLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ListaProductosNoLogViewModel viewModel);
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

        void passDataToNextScreen(ListaProductosNoLogState state);

        ListaProductosNoLogState getDataFromPreviousScreen();
    }
}
