package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.Carrito.CarritoActivity;
import es.hotmail.pcasteres.elverol.ListaProductosLog.ListaProductosLogActivity;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.UserItem;

public class PrincipalLoginRouter implements PrincipalLoginContract.Router {

    public static String TAG = PrincipalLoginRouter.class.getSimpleName();

    private AppMediator mediator;

    public PrincipalLoginRouter(AppMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public void navigateToListaProductosLoginScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ListaProductosLogActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
    public void passDataToListaProductosLoginScreen(CategoryItem item, UserItem userItem) {

    }

    @Override
    public void passDataToCarritoScreen(int userItem){
        mediator.setUser(userItem);
    }

    @Override
    public void passDataToListaProductosLoginScreen(CategoryItem item, int userItem) {
        mediator.setCategory(item);
        mediator.setUser(userItem);
    }
    @Override
    public PrincipalLoginState getDataFromPreviousScreen() {
        PrincipalLoginState state = mediator.getPrincipalLoginState();
        return state;
    }
}
