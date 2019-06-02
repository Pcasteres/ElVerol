package es.hotmail.pcasteres.elverol.PrincipalNoLog;

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

public class PrincipalNoLogActivity
        extends AppCompatActivity implements PrincipalNoLogContract.View {

    public static String TAG = PrincipalNoLogActivity.class.getSimpleName();

    private PrincipalNoLogContract.Presenter presenter;
    private AppMediator mediator;
    private PrincipalNoLogAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_no_log);
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        //inicializar los botones
        // do the setup
        @SuppressLint("WrongViewCast") ImageView btn= (ImageView) findViewById(R.id.login1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToLoginScreen();
            }
        });
        listAdapter = new PrincipalNoLogAdapter(new View.OnClickListener() {

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
        PrincipalNoLogScreen.configure(this);

        // do some work
        presenter.fetchCategoryListData();
    }


    @Override
    public void injectPresenter(PrincipalNoLogContract.Presenter presenter) {
        this.presenter = presenter;
    }



    @Override
    public void displayCategoryListData(final PrincipalNoLogViewModel viewModel) {
            Log.e(TAG, "displayCategoryListData()");

            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    // deal with the data
                    listAdapter.setItems(viewModel.categories);
                }

            });
    }

    public void onLogClick(View view) {

    }
}
