package es.hotmail.pcasteres.elverol.DetalleNoLog;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.Login.LoginActivity;
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

    @Override
    public void navigateToLoginScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
