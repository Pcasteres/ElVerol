package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class PrincipalNoLogRouter implements PrincipalNoLogContract.Router {

    public static String TAG = PrincipalNoLogRouter.class.getSimpleName();

    private AppMediator mediator;

    public PrincipalNoLogRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PrincipalNoLogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(PrincipalNoLogState state) {
        mediator.setPrincipalNoLogState(state);
    }

    @Override
    public PrincipalNoLogState getDataFromPreviousScreen() {
        PrincipalNoLogState state = mediator.getPrincipalNoLogState();
        return state;
    }
}
