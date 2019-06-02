package es.hotmail.pcasteres.elverol.DetalleNoLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.ProductItem;

interface DetalleNoLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(DetalleNoLogViewModel viewModel);

        void displayProductDetailData(DetalleNoLogViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);
        // metodo que llama al router para tomar el objeto seleccionado en la pantalla anterior
        void fetchDataProduct();
        // Al seleccionar el boton de login llama al router para ir a la pantalla del Login
        void goToLoginScreen();
    }

    interface Model {

    }

    interface Router {
        // metodo para tomar el producto seleccionado en la pantalla anterior
        ProductItem getDataFromProductListScreen();
        // metodo para ir a la pantalla de login
        void navigateToLoginScreen();
    }
}
