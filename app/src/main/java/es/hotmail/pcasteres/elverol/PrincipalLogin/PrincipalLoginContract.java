package es.hotmail.pcasteres.elverol.PrincipalLogin;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

interface PrincipalLoginContract {

    interface View {
        void injectPresenter(Presenter presenter);
        //Muestra las categorias en pantalla
        void displayCategoryListData(PrincipalLoginViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);
        // Llama al modelo para cargar los datos de las categorias
        void fetchCategoryListData();
        // Llama al modelo para cargar los datos de la factura
        void fetchFacturaData();
        // Al seleccionar una categoria pasa la categoria y llama al router para ir a la pantalla de ListaProductosNoLog
        void selectProductListData(CategoryItem item);
        // Al seleccionar el carrito llama al router para ir a la pantalla del carrito
        void selectCarritoListData();
    }

    interface Model {
        // Toma los datos de la Categoria del repositorio
        void fetchCategoryListData(
                RepositoryContract.GetCategoryListCallback callback);
        // Toma los datos de la factura del repositorio
        void fetchfacturaListData(
                RepositoryContract.GetFacturaCallback callback);
    }

    interface Router {
        // metodo para ir a la siguiente pantalla
        void navigateToListaProductosLoginScreen();
        // metodo para ir al carrito
        void navigateToCarritoScreen();
        // metodo para pasar los datos al carrito
        void passDataToCarritoScreen(FacturaItem userItem);
        // metodo para pasar la categoria a la siguiente pantalla
        void passDataToListaProductosLoginScreen(CategoryItem item, int userItem, FacturaItem fac);

        PrincipalLoginState getDataFromPreviousScreen();
    }
}
