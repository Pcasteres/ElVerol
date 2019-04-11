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

        void fetchListaProductosNoLogData();

        void selectProductListData(ProductItem item);
    }

    interface Model {

        void fetchListaProductosNoLogData(
                CategoryItem category, RepositoryContract.GetProductListCallback callback);

        //void fetchListaProductosNoLogData(
        //        int category, RepositoryContract.GetProductListCallback callback);
    }

    interface Router {
        void navigateToDetalleNoLogScreen();

        void passDataToDetalleNoLogActivity(ProductItem item);

        ListaProductosNoLogState getDataFromPreviousScreen();

        CategoryItem getDataFromPrincipalNoLog();
    }
}
