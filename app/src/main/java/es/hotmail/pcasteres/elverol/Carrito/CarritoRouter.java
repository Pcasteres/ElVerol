package es.hotmail.pcasteres.elverol.Carrito;

import android.util.Log;
import android.content.Intent;
import android.content.Context;
import es.hotmail.pcasteres.elverol.app.AppMediator;

public class CarritoRouter implements CarritoContract.Router {

    public static String TAG = CarritoRouter.class.getSimpleName();

    private AppMediator mediator;

    public CarritoRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, CarritoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(CarritoState state) {

    }

    @Override
    public CarritoState getDataFromPreviousScreen() {
        CarritoState state = mediator.getCarritoState();
        return state;
    }
}
