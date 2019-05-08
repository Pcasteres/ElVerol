package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import es.hotmail.pcasteres.elverol.Login.LoginActivity;
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
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
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
    protected void onResume() {
        super.onResume();

        // do some work
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
