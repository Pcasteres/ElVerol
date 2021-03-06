package es.hotmail.pcasteres.elverol.PrincipalLogin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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
        @SuppressLint("WrongViewCast") ImageView btn= (ImageView) findViewById(R.id.carritoa);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectCarritoListData();
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
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        // do the setup
        PrincipalLoginScreen.configure(this);

        // do some work
        presenter.fetchFacturaData();
        presenter.fetchCategoryListData();

    }


    @Override
    public void injectPresenter(PrincipalLoginContract.Presenter presenter) {
        this.presenter = presenter;
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
