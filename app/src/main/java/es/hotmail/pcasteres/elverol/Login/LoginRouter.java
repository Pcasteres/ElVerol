package es.hotmail.pcasteres.elverol.Login;

import android.content.Intent;
import android.content.Context;

import es.hotmail.pcasteres.elverol.NewUser.NewUserActivity;
import es.hotmail.pcasteres.elverol.PrincipalLogin.PrincipalLoginActivity;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.UserItem;

public class LoginRouter implements LoginContract.Router {

    public static String TAG = LoginRouter.class.getSimpleName();

    private AppMediator mediator;

    public LoginRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToPrincipalLog() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PrincipalLoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToNewUser() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, NewUserActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(UserItem userItem) {
        mediator.setUser(1);
    }

    @Override
    public LoginState getDataFromPreviousScreen() {
        LoginState state = mediator.getLoginState();
        return state;
    }
}
