package es.hotmail.pcasteres.elverol.ListaProductosLog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class ListaProductosLogActivity
        extends AppCompatActivity implements ListaProductosLogContract.View {

    public static String TAG = ListaProductosLogActivity.class.getSimpleName();

    private ListaProductosLogContract.Presenter presenter;
    private ListaProductosLogAdapter listAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos_log);
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        @SuppressLint("WrongViewCast") ImageView btn= (ImageView) findViewById(R.id.carrito);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectCarritoListData();
            }
        });
        //findViewById(R.id.Loginprincipal1).setOnClickListener(this);
        // do the setup

        listAdapter = new ListaProductosLogAdapter( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ProductItem item = (ProductItem) view.getTag();
                presenter.selectProductListData(item);
            }
        });

        @SuppressLint("WrongViewCast") RecyclerView recyclerView = findViewById(R.id.product_list);
        recyclerView.setAdapter(listAdapter);

        ListaProductosLogScreen.configure(this);

        presenter.fetchFacturaData();
        presenter.fetchListaProductosLogData();

    }


    @Override
    public void injectPresenter(ListaProductosLogContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ListaProductosLogViewModel viewModel) {

    }

    @Override
    public void displayListaProductosLogData(final ListaProductosLogViewModel viewModel) {
        Log.e(TAG, "displayListaProductosNoLogData()");

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                CategoryItem category = viewModel.category;

                listAdapter.setItems(viewModel.products);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}