package es.hotmail.pcasteres.elverol.DetalleLog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.hotmail.pcasteres.elverol.R;

public class DetalleLogActivity
        extends AppCompatActivity implements DetalleLogContract.View {

    public static String TAG = DetalleLogActivity.class.getSimpleName();

    private DetalleLogContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_log);

        // do the setup
        DetalleLogScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(DetalleLogContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(DetalleLogViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
