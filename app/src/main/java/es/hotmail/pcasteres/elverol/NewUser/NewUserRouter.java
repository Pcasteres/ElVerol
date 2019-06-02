package es.hotmail.pcasteres.elverol.NewUser;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.PrincipalLogin.PrincipalLoginActivity;
import es.hotmail.pcasteres.elverol.app.AppMediator;

public class NewUserRouter implements NewUserContract.Router {

    public static String TAG = NewUserRouter.class.getSimpleName();

    private AppMediator mediator;

    public NewUserRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PrincipalLoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(NewUserState state) {    }

    @Override
    public NewUserState getDataFromPreviousScreen() {
        NewUserState state = mediator.getNewUserState();
        return state;
    }
}
