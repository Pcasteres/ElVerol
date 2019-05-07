package es.hotmail.pcasteres.elverol.Login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.hotmail.pcasteres.elverol.NewUser.NewUserActivity;
import es.hotmail.pcasteres.elverol.PrincipalLogin.PrincipalLoginActivity;
import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.RepositoryContract;


public class LoginActivity
        extends AppCompatActivity implements LoginContract.View {

    public static String TAG = LoginActivity.class.getSimpleName();
    private AppMediator mediator;
    private LoginContract.Presenter presenter;
    private LoginContract.Model model;
    private RepositoryContract repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        final EditText editText= (EditText) findViewById(R.id.nombredeusuario);
        final EditText editText2= (EditText) findViewById(R.id.contraseña);
        @SuppressLint("WrongViewCast") Button btn= (Button) findViewById(R.id.iniciarsesion);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PrincipalLoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
        @SuppressLint("WrongViewCast") Button btn2= (Button) findViewById(R.id.registrarse);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewUserActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        // do the setup
        LoginScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(LoginViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    public void onClickLogin(View view) {
    }
}
