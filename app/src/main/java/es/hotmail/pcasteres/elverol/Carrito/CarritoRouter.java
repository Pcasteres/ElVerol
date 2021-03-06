package es.hotmail.pcasteres.elverol.Carrito;

import android.content.Context;
import android.content.Intent;

import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.FacturaItem;

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
    public FacturaItem getDataFromPreviousScreen() {
        FacturaItem facturaItem = mediator.facturaItem;
        return facturaItem;
    }
}
