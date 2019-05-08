package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

interface PrincipalNoLogContract {

    interface View {

        void injectPresenter(Presenter presenter);
        //Muestra las categorias en pantalla
        void displayCategoryListData(PrincipalNoLogViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);
        // Llama al modelo para cargar los datos de las categorias
        void fetchCategoryListData();
        // Al seleccionar una categoria pasa la categoria y llama al router para ir a la pantalla de ListaProductosNoLog
        void selectProductListData(CategoryItem item);
    }

    interface Model {
        // Toma los datos de la Categoria del repositorio
        void fetchCategoryListData(
                RepositoryContract.GetCategoryListCallback callback);
    }

    interface Router {
        // metodo para ir a la siguiente pantalla
        void navigateToListaProductosNoLogScreen();
        // metodo para pasar la categoria a la siguiente pantalla
        void passDataToListaProductosNoLogScreen(CategoryItem item);

        PrincipalNoLogState getDataFromPreviousScreen();
    }
}
