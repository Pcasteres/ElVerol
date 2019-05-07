package es.hotmail.pcasteres.elverol.Login;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.RepositoryContract;
import es.hotmail.pcasteres.elverol.data.UserItem;

interface LoginContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(LoginViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {

        void fetchLoginData(
                String user, String pass, RepositoryContract.GetUserCallback callback);

        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(UserItem userItem);

        LoginState getDataFromPreviousScreen();
    }
}
