package es.hotmail.pcasteres.elverol.DetalleNoLog;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class DetalleNoLogRouter implements DetalleNoLogContract.Router {

    public static String TAG = DetalleNoLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public DetalleNoLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, DetalleNoLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(DetalleNoLogState state) {
        mediator.setDetalleNoLogState(state);
    }

    @Override
    public DetalleNoLogState getDataFromPreviousScreen() {
        DetalleNoLogState state = mediator.getDetalleNoLogState();
        return state;
    }
}
