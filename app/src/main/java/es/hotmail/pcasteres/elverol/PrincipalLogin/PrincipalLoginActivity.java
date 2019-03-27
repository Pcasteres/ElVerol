package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.hotmail.pcasteres.elverol.R;

public class PrincipalLoginActivity
        extends AppCompatActivity implements PrincipalLoginContract.View {

    public static String TAG = PrincipalLoginActivity.class.getSimpleName();

    private PrincipalLoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_login);
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        // do the setup
        PrincipalLoginScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(PrincipalLoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(PrincipalLoginViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
