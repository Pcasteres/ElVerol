package es.hotmail.pcasteres.elverol.PrincipalLogin;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
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
        // Al seleccionar una categoria pasa la categoria y llama al router para ir a la pantalla de ListaProductosNoLog
        void selectProductListData(CategoryItem item);
        // Al seleccionar el carrito,  y llama al router para ir a la pantalla de ListaProductosNoLog
        void selectCarritoListData();
    }

    interface Model {
        // Toma los datos de la Categoria del repositorio
        void fetchCategoryListData(
                RepositoryContract.GetCategoryListCallback callback);
    }

    interface Router {
        void navigateToListaProductosLoginScreen();

        void navigateToCarritoScreen();

        void passDataToCarritoScreen(int userItem);

        void passDataToListaProductosLoginScreen(CategoryItem item, int userItem);

        PrincipalLoginState getDataFromPreviousScreen();
    }
}
