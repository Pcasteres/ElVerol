package es.hotmail.pcasteres.elverol.ListaProductosLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
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
        // Llama al modelo para cargar los productos de la categoria seleccionada en la pantalla anterior
        void fetchListaProductosLogData();
        // Al seleccionar un producto, lo pasa, y llama al router para ir a la pantalla de DetalleLog
        void selectProductListData(ProductItem item);

        void fetchFacturaData();
        // Llama al router para ir al la pantalla del carrito
        void selectCarritoListData();
    }

    interface Model {
        // Toma los datos de los productos del repositorio
        void fetchListaProductosLogData(
                CategoryItem category, RepositoryContract.GetProductListCallback callback);
        // Toma los datos de la factura del repositorio
        void fetchfacturaListData(
                RepositoryContract.GetFacturaCallback callback);
    }

    interface Router {
        // metodo para ir a la pantalla de detalleLog
        void navigateToDetalleLogScreen();
        // metodo para ir a la pantalla de carrito
        void navigateToCarritoScreen();
        // metodo para pasar los datos del producto seleccionado.
        void passDataToDetalleLogActivity(ProductItem item, FacturaItem fac);

        // metodo para pasar los datos de la factura activa.
        void passDataToCarritoScreen(FacturaItem userItem);

        ListaProductosLogState getDataFromPreviousScreen();
        // metodo para tomar la categoria seleccionada en la pantalla anterior
        CategoryItem getDataFromPrincipalLog();
    }
}
