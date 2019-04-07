package es.hotmail.pcasteres.elverol.Carrito;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.hotmail.pcasteres.elverol.R;

public class CarritoActivity
        extends AppCompatActivity implements CarritoContract.View {

    public static String TAG = CarritoActivity.class.getSimpleName();

    private CarritoContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        //Código para eliminar el action bar
        getSupportActionBar().hide();

        // do the setup
        CarritoScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(CarritoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(CarritoViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
