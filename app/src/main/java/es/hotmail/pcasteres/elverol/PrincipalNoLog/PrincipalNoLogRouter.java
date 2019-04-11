package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.ListaProductosNoLog.ListaProductosNoLogActivity;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CategoryItem;

public class PrincipalNoLogRouter implements PrincipalNoLogContract.Router {

    public static String TAG = PrincipalNoLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public PrincipalNoLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {

    }

    @Override
    public void passDataToNextScreen(PrincipalNoLogState state) {

    }

    @Override
    public void navigateToListaProductosNoLogScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ListaProductosNoLogActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToListaProductosNoLogScreen(int item) {


    }

    @Override
    public void passDataToListaProductosNoLogScreen(CategoryItem item) {
        mediator.setCategory(item);
    }
    @Override
    public PrincipalNoLogState getDataFromPreviousScreen() {
        PrincipalNoLogState state = mediator.getPrincipalNoLogState();
        return state;
    }
}
