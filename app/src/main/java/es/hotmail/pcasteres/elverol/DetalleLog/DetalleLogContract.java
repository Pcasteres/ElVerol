package es.hotmail.pcasteres.elverol.DetalleLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.ProductItem;

interface DetalleLogContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(DetalleLogViewModel viewModel);

        void displayProductDetailData(DetalleLogViewModel viewModel);
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
