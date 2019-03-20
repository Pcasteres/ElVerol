package es.hotmail.pcasteres.elverol.ListaProductosLog;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class ListaProductosLogRouter implements ListaProductosLogContract.Router {

    public static String TAG = ListaProductosLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public ListaProductosLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ListaProductosLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ListaProductosLogState state) {
        mediator.setListaProductosLogState(state);
    }

    @Override
    public ListaProductosLogState getDataFromPreviousScreen() {
        ListaProductosLogState state = mediator.getListaProductosLogState();
        return state;
    }
}
