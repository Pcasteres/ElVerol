package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import java.lang.ref.WeakReference;

interface PrincipalNoLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PrincipalNoLogViewModel viewModel);
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

        void passDataToNextScreen(PrincipalNoLogState state);

        PrincipalNoLogState getDataFromPreviousScreen();
    }
}
