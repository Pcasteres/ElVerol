package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import es.hotmail.pcasteres.elverol.R;

public class PrincipalNoLogActivity
        extends AppCompatActivity implements PrincipalNoLogContract.View {

    public static String TAG = PrincipalNoLogActivity.class.getSimpleName();

    private PrincipalNoLogContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_no_log);

        //inicializar los botones
        // do the setup
        PrincipalNoLogScreen.configure(this);
        //findViewById(R.id.relojes).setOnClickListener(this);
        //findViewById(R.id.exterior).setOnClickListener(this);
       // findViewById(R.id.portavelas).setOnClickListener(this);
       // findViewById(R.id.velas).setOnClickListener(this);
        //findViewById(R.id.cuadros).setOnClickListener(this);
        //findViewById(R.id.odmetalart).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(PrincipalNoLogContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(PrincipalNoLogViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
