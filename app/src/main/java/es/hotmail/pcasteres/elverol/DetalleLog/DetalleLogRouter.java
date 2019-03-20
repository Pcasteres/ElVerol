package es.hotmail.pcasteres.elverol.DetalleLog;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class DetalleLogRouter implements DetalleLogContract.Router {

    public static String TAG = DetalleLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public DetalleLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, DetalleLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(DetalleLogState state) {
        mediator.setDetalleLogState(state);
    }

    @Override
    public DetalleLogState getDataFromPreviousScreen() {
        DetalleLogState state = mediator.getDetalleLogState();
        return state;
    }
}
