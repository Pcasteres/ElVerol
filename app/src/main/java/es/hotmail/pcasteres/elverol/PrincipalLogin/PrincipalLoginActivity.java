package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import es.hotmail.pcasteres.elverol.Carrito.CarritoActivity;
import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.app.AppMediator;
import es.hotmail.pcasteres.elverol.data.CategoryItem;

public class PrincipalLoginActivity
        extends AppCompatActivity implements PrincipalLoginContract.View {

    public static String TAG = PrincipalLoginActivity.class.getSimpleName();

    private PrincipalLoginContract.Presenter presenter;
    private AppMediator mediator;
    private PrincipalLoginAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_login);
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        @SuppressLint("WrongViewCast") ImageView btn= (ImageView) findViewById(R.id.carrito);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CarritoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
        //inicializar los botones
        // do the setup
        listAdapter = new PrincipalLoginAdapter(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                CategoryItem item = (CategoryItem) view.getTag();
                presenter.selectProductListData(item);
            }
        });

                RecyclerView recyclerView = findViewById(R.id.category_list);
        recyclerView.setAdapter(listAdapter);

        // do the setup
        PrincipalLoginScreen.configure(this);

        // do some work
        presenter.fetchCategoryListData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
    }

    @Override
    public void injectPresenter(PrincipalLoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(PrincipalLoginViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
     //   ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void displayCategoryListData(final PrincipalLoginViewModel viewModel) {
            Log.e(TAG, "displayCategoryListData()");

            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    // deal with the data
                    listAdapter.setItems(viewModel.categories);
                }

            });
    }

}
