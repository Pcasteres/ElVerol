package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

interface ListaProductosNoLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ListaProductosNoLogViewModel viewModel);

        void displayListaProductosNoLogData(ListaProductosNoLogViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);
        // Llama al modelo para cargar los productos de la categoria seleccionada en la pantalla anterior
        void fetchListaProductosNoLogData();
        // Al seleccionar un producto, lo pasa, y llama al router para ir a la pantalla de DetalleNoLog
        void selectProductListData(ProductItem item);
        // Al seleccionar el boton de login llama al router para ir a la pantalla del Login
        void goToLoginScreen();
    }

    interface Model {
        // Toma los datos de los productos del repositorio
        void fetchListaProductosNoLogData(
                CategoryItem category, RepositoryContract.GetProductListCallback callback);

    }

    interface Router {
        // metodo para ir a la siguiente pantalla
        void navigateToDetalleNoLogScreen();
        // metodo para pasar el objeto a la siguiente pantalla
        void passDataToDetalleNoLogActivity(ProductItem item);

        ListaProductosNoLogState getDataFromPreviousScreen();
        // metodo para tomar la categoria seleccionada en la pantalla anterior
        CategoryItem getDataFromPrincipalNoLog();
        // metodo para ir a la pantalla de login
        void navigateToLoginScreen();
    }
}
