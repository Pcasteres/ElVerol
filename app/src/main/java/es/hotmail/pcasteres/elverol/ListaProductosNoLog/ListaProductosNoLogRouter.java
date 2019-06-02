package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.DetalleNoLog.DetalleNoLogActivity;
import es.hotmail.pcasteres.elverol.Login.LoginActivity;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class ListaProductosNoLogRouter implements ListaProductosNoLogContract.Router {

    public static String TAG = ListaProductosNoLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public ListaProductosNoLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToDetalleNoLogScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, DetalleNoLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToDetalleNoLogActivity(ProductItem item) {
        mediator.setProduct(item);
    }

    @Override
    public ListaProductosNoLogState getDataFromPreviousScreen() {
        ListaProductosNoLogState state = mediator.getListaProductosNoLogState();
        return state;
    }
    @Override
    public CategoryItem getDataFromPrincipalNoLog() {
        CategoryItem category = mediator.getCategory();
        return category;
    }

    @Override
    public void navigateToLoginScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
