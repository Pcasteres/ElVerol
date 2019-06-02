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
        // Al seleccionar el boton iniciar sesion llama al router para ir a la pantalla de PrincipalLogin
        void iniciarSesion();
        // Al seleccionar el boton registrarse llama al router para ir a la pantalla de newuser
        void newUser();
    }

    interface Model {

        void fetchLoginData(
                String user, String pass, RepositoryContract.GetUserCallback callback);

        String fetchData();
    }

    interface Router {
        // metodo para ir a la pagina PrincipalLogin
        void navigateToPrincipalLog();
        // metodo para ir a la pantalla de registro de usuario
        void navigateToNewUser();
        // metodo para pasar datos a una nueva pantalla en caso de que fuera necesario
        void passDataToNextScreen(UserItem userItem);

        LoginState getDataFromPreviousScreen();
    }
}
