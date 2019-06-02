package es.hotmail.pcasteres.elverol.DetalleLog;

import java.lang.ref.WeakReference;

import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;

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
        // Llama al modelo para sacar los datos del producto
        void fetchDataProduct();
        // Llama al modelo para sacar los datos de la factura
        void fetchFacturaData();
        // Llama al router para ir al la pantalla del carrito
        void selectCarritoListData();
        // Reduce la cantidad de objetos que quieres añadir
        void reducircantidad();
        // Aumenta la cantidad de objetos que quieres añadir
        void aumentarcantidad();
        // Llama al modelo para que se añada el objeto al carrito, si ya esta dentro del carrito modifica la cantidad
        void insertCarritoItem();
        // Al añadir el producto al carrito se actualiza el stock
        void updateproductdata(int idproduct);
        // Extrae los datos del objeto para modificarlos y actualizarlos
        void fetchProductData(int in);
    }

    interface Model {

        // Metodo para tomar los datos de la factura del repositorio
        void fetchfacturaListData(
                RepositoryContract.GetFacturaCallback callback);
        // Metodo para insertar un nuevo objeto en el carrito
        void insertCarritoItem(
                CarritoItem item, RepositoryContract.InsertCarritoCallback callback);
        // Metodo para actualizar un producto del carrito
        void updateCarritoItem(
                CarritoItem item, RepositoryContract.UpdateCarritoCallback callback);
        // Metodo para comprobar si el objeto ya existe en el carrito
        void searchCarritoItem(int id, int fac,
                               RepositoryContract.GetCarritoItemCallback callback);
        // Metodo para actualizar el stock del producto introducido en el carrito
        void updateproduct(ProductItem productItem, RepositoryContract.UpdateProductCallback callback);
        // Metodo para sacar los datos del producto del repositorio
        void fetchProductData(int in,
                              RepositoryContract.GetProductDataCallback callback);
    }

    interface Router {

        ProductItem getDataFromProductListScreen1();

        FacturaItem getDataFromProductListScreen2();
        // metodo para ir a la pantalla de carrito
        void navigateToCarritoScreen();
        // metodo para pasar los datos de la factura activa.
        void passDataToCarritoScreen(FacturaItem userItem);
    }
}
