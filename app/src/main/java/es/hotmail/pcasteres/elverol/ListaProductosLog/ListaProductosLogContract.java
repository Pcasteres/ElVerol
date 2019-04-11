package es.hotmail.pcasteres.elverol.ListaProductosLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

interface ListaProductosLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ListaProductosLogViewModel viewModel);

        void displayListaProductosLogData(ListaProductosLogViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);


        void fetchListaProductosNoLogData();

        void selectProductListData(ProductItem item);
    }

    interface Model {

        void fetchListaProductosLogData(
                CategoryItem category, RepositoryContract.GetProductListCallback callback);
    }

    interface Router {

        void navigateToDetalleLogScreen();

        void passDataToDetalleLogActivity(ProductItem item);

        ListaProductosLogState getDataFromPreviousScreen();

        CategoryItem getDataFromPrincipalLog();
    }
}
