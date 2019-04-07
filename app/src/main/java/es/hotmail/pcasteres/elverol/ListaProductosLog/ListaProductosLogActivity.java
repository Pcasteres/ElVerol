package es.hotmail.pcasteres.elverol.ListaProductosLog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.hotmail.pcasteres.elverol.R;

public class ListaProductosLogActivity
        extends AppCompatActivity implements ListaProductosLogContract.View {

    public static String TAG = ListaProductosLogActivity.class.getSimpleName();

    private ListaProductosLogContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos_log);
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        // do the setup
        ListaProductosLogScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ListaProductosLogContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ListaProductosLogViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
