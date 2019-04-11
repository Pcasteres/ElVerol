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

        void fetchDataProduct();

    }

    interface Model {
        String fetchData();
    }

    interface Router {

        ProductItem getDataFromProductListScreen();
    }
}
