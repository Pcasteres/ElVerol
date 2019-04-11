package es.hotmail.pcasteres.elverol.DetalleNoLog;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class DetalleNoLogRouter implements DetalleNoLogContract.Router {

    public static String TAG = DetalleNoLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public DetalleNoLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public ProductItem getDataFromProductListScreen() {
        ProductItem product = mediator.getProduct();
        return product;
    }
}
