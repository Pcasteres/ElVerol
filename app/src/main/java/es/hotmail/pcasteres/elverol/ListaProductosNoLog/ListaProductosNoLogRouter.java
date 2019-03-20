package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class ListaProductosNoLogRouter implements ListaProductosNoLogContract.Router {

    public static String TAG = ListaProductosNoLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public ListaProductosNoLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ListaProductosNoLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ListaProductosNoLogState state) {
        mediator.setListaProductosNoLogState(state);
    }

    @Override
    public ListaProductosNoLogState getDataFromPreviousScreen() {
        ListaProductosNoLogState state = mediator.getListaProductosNoLogState();
        return state;
    }
}
