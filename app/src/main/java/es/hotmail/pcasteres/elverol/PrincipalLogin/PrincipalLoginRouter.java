package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class PrincipalLoginRouter implements PrincipalLoginContract.Router {

    public static String TAG = PrincipalLoginRouter.class.getSimpleName();

    private AppMediator mediator;

    public PrincipalLoginRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PrincipalLoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(PrincipalLoginState state) {
        mediator.setPrincipalLoginState(state);
    }

    @Override
    public PrincipalLoginState getDataFromPreviousScreen() {
        PrincipalLoginState state = mediator.getPrincipalLoginState();
        return state;
    }
}
