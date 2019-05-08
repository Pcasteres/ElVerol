package es.hotmail.pcasteres.elverol.Carrito;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.data.CarritoItem;

public class CarritoActivity
        extends AppCompatActivity implements CarritoContract.View {

    public static String TAG = CarritoActivity.class.getSimpleName();

    private CarritoContract.Presenter presenter;
    private CarritoAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        //Código para eliminar el action bar
        getSupportActionBar().hide();
        listAdapter = new CarritoAdapter(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                CarritoItem item = (CarritoItem) view.getTag();
            }
        });

        @SuppressLint("WrongViewCast") RecyclerView recyclerView = findViewById(R.id.carrito_list);
        recyclerView.setAdapter(listAdapter);

        // do the setup
        CarritoScreen.configure(this);

        presenter.fetchData();
    }


    @Override
    public void injectPresenter(CarritoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(final CarritoViewModel viewModel) {
        Log.e(TAG, "displayDataCarrito()");
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                int category = viewModel.userid;

                listAdapter.setItems(viewModel.Carritoo);
            }
        });
        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
