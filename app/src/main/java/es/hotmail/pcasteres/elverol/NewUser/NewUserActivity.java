package es.hotmail.pcasteres.elverol.NewUser;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.hotmail.pcasteres.elverol.R;

public class NewUserActivity
        extends AppCompatActivity implements NewUserContract.View {

    public static String TAG = NewUserActivity.class.getSimpleName();

    private NewUserContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        EditText Nombre = (EditText) findViewById(R.id.nombre);
        String nombre = Nombre.getText().toString();
        EditText User = (EditText) findViewById(R.id.usuario);
        String user = User.getText().toString();
        EditText Direccion = (EditText) findViewById(R.id.direccion);
        String direccion = Direccion.getText().toString();
        EditText Contrasena = (EditText) findViewById(R.id.contrasena);
        String contrasena = Contrasena.getText().toString();
        EditText Repetircontrasena = (EditText) findViewById(R.id.contrasenarepetida);
        String repetircontrasena = Repetircontrasena.getText().toString();
        EditText Municipio = (EditText) findViewById(R.id.municipio);
        String municipio = Municipio.getText().toString();
        EditText Telefono = (EditText) findViewById(R.id.telefono);
        String telefono = Telefono.getText().toString();
        EditText Correo = (EditText) findViewById(R.id.correo);
        String correo = Correo.getText().toString();
        @SuppressLint("WrongViewCast") Button btn= (Button) findViewById(R.id.finReg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.passToNextScreen();
            }
        });

        //Código para eliminar el action bar
        getSupportActionBar().hide();




        // do the setup
        NewUserScreen.configure(this);
    }


    @Override
    public void injectPresenter(NewUserContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(NewUserViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
}
