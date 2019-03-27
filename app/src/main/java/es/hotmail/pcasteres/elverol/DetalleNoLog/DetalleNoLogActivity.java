package es.hotmail.pcasteres.elverol.DetalleNoLog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.hotmail.pcasteres.elverol.R;

public class DetalleNoLogActivity
        extends AppCompatActivity implements DetalleNoLogContract.View {

    public static String TAG = DetalleNoLogActivity.class.getSimpleName();

    private DetalleNoLogContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_no_log);
        //Código para eliminar el action bar
        getSupportActionBar().hide();

        // do the setup
        DetalleNoLogScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(DetalleNoLogContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(DetalleNoLogViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
