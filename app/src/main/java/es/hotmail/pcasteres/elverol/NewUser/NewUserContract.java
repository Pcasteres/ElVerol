package es.hotmail.pcasteres.elverol.NewUser;

import java.lang.ref.WeakReference;

interface NewUserContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(NewUserViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
        // Al seleccionar el boton finalizar registro llama al router para ir a la pantalla de PrincipalLogin
        void passToNextScreen();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        // metodo para ir a la pagina PrincipalLogin
        void navigateToNextScreen();

        void passDataToNextScreen(NewUserState state);

        NewUserState getDataFromPreviousScreen();
    }
}
