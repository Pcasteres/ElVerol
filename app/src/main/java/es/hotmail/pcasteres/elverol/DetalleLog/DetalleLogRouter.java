package es.hotmail.pcasteres.elverol.DetalleLog;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class DetalleLogRouter implements DetalleLogContract.Router {

    public static String TAG = DetalleLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public DetalleLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public ProductItem getDataFromProductListScreen() {
        ProductItem product = mediator.getProduct();
        return product;
    }
}
