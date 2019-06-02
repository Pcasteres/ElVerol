package es.hotmail.pcasteres.elverol.Carrito;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

interface CarritoContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(CarritoViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);
        // Metodo para actualizar los datos del carrito
        void fetchData();
        // Llama al modelo para sacar los datos de la factura
        void fetchFacturaData();
        // Llama al modelo para sacar los datos del producto que se va a borrar y poder actualizarlo posteriormente
        void fetchProductData(int in);
        // Metodo que llama al modelo para eliminar un objeto del carrito
        void deleteCarritoItem(CarritoItem item);
        // Metodo que llama al modelo y aumenta el stock del objeto eliminado
        void updateproductdata(int idproduct);
    }

    interface Model {

        // Saca los datos de la factura del repositorio
        void fetchData(
                FacturaItem facturaItem, RepositoryContract.GetCarritoListCallback callback);
        // Saca los datos del producto del repositorio
        void fetchProductData(int in,
                              RepositoryContract.GetProductDataCallback callback);
        // Saca una lista de todos los productos del repositorio para rellenar los datos de la lista.
        void fetchData2(int id , RepositoryContract.GetAllProductListCallback callback);
        // Metodo para borrar un objeto del carrito
        void deleteCarrito(
                CarritoItem carritoItem, RepositoryContract.DeleteCarritoCallback callback);
        // Metodo para aumentar la cantidad de stock de un producto que va a ser borrado
        void updateproduct(ProductItem productItem, RepositoryContract.UpdateProductCallback callback);
        // Metodo para sacar la factura del repositorio
        void fetchfacturaListData(
                RepositoryContract.GetFacturaCallback callback);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(CarritoState state);
        // Toma los datos de la factura de la pantalla anterior
        FacturaItem getDataFromPreviousScreen();
    }
}
