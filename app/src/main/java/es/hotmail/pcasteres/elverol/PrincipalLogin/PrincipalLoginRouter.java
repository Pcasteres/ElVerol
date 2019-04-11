package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.ListaProductosLog.ListaProductosLogActivity;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CategoryItem;

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
    public void passDataToListaProductosLoginScreen(CategoryItem item) {
        mediator.setCategory(item);
    }
    @Override
    public PrincipalLoginState getDataFromPreviousScreen() {
        PrincipalLoginState state = mediator.getPrincipalLoginState();
        return state;
    }
}
