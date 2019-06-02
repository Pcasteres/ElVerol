package es.hotmail.pcasteres.elverol.ListaProductosLog;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.Carrito.CarritoActivity;
import es.hotmail.pcasteres.elverol.DetalleLog.DetalleLogActivity;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class ListaProductosLogRouter implements ListaProductosLogContract.Router {


    public static String TAG = ListaProductosLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public ListaProductosLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToDetalleLogScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, DetalleLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToCarritoScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, CarritoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    @Override
    public void passDataToDetalleLogActivity(ProductItem item,FacturaItem fac) {
        mediator.setProduct(item);
        mediator.setFactura(fac);
    }

    @Override
    public void passDataToCarritoScreen(FacturaItem fac){
        mediator.setFacturaItem(fac);
    }

    @Override
    public ListaProductosLogState getDataFromPreviousScreen() {
        ListaProductosLogState state = mediator.getListaProductosLogState();
        return state;
    }
    @Override
    public CategoryItem getDataFromPrincipalLog() {
        CategoryItem category = mediator.getCategory();
        return category;
    }
}
