package es.hotmail.pcasteres.elverol.PrincipalLogin;

import java.lang.ref.WeakReference;

interface PrincipalLoginContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PrincipalLoginViewModel viewModel);
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

        void passDataToNextScreen(PrincipalLoginState state);

        PrincipalLoginState getDataFromPreviousScreen();
    }
}
