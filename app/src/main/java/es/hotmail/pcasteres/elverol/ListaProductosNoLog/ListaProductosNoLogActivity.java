package es.hotmail.pcasteres.elverol.ListaProductosNoLog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.hotmail.pcasteres.elverol.R;

public class ListaProductosNoLogActivity
        extends AppCompatActivity implements ListaProductosNoLogContract.View {

    public static String TAG = ListaProductosNoLogActivity.class.getSimpleName();

    private ListaProductosNoLogContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos_no_log);
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        // do the setup
        ListaProductosNoLogScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ListaProductosNoLogContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ListaProductosNoLogViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
