package es.hotmail.pcasteres.elverol.DetalleLog;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.Carrito.CarritoActivity;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class DetalleLogRouter implements DetalleLogContract.Router {

    public static String TAG = DetalleLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public DetalleLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public ProductItem getDataFromProductListScreen1() {
        ProductItem product = mediator.getProduct();
        return product;
    }

    @Override
    public FacturaItem getDataFromProductListScreen2() {
        FacturaItem product = mediator.getFacturaItem();
        return product;
    }

    @Override
    public void navigateToCarritoScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, CarritoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToCarritoScreen(FacturaItem userItem){
        mediator.setFacturaItem(userItem);
    }
}
