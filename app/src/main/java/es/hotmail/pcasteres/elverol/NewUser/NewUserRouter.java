package es.hotmail.pcasteres.elverol.NewUser;

import android.util.Log;
import android.content.Intent;
import android.content.Context;
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
        Intent intent = new Intent(context, NewUserActivity.class);
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
