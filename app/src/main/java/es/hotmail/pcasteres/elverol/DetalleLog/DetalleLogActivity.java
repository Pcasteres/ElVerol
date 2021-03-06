package es.hotmail.pcasteres.elverol.DetalleLog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class DetalleLogActivity
        extends AppCompatActivity implements DetalleLogContract.View {

    public static String TAG = DetalleLogActivity.class.getSimpleName();

    private DetalleLogContract.Presenter presenter;

    public int cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_log);
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        @SuppressLint("WrongViewCast") ImageView btn= (ImageView) findViewById(R.id.carrito);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectCarritoListData();
            }
        });
        @SuppressLint("WrongViewCast") Button menos= (Button) findViewById(R.id.menos);
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.reducircantidad();
            }
        });
        @SuppressLint("WrongViewCast") Button mas= (Button) findViewById(R.id.masss);
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.aumentarcantidad();
            }
        });
        @SuppressLint("WrongViewCast") Button anadir= (Button) findViewById(R.id.alcarrito);
        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                presenter.insertCarritoItem();
            }
        });



        // do the setup
        DetalleLogScreen.configure(this);

        // do some work
        presenter.fetchFacturaData();
        presenter.fetchDataProduct();
    }


    @Override
    public void injectPresenter(DetalleLogContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(DetalleLogViewModel viewModel) {

    }


    @Override
    public void displayProductDetailData(DetalleLogViewModel viewModel) {
        Log.e(TAG, "displayProductDetailData()");

        // deal with the data
        ProductItem product = viewModel.product;
        String stock= String.valueOf(product.stock);




        Log.e(TAG, String.valueOf(viewModel.cantidad));
        if (viewModel.cantidad!=0){}else{viewModel.cantidad=1;}

        ((TextView) findViewById(R.id.nombre)).setText(product.name);
        ((TextView) findViewById(R.id.precio)).setText(product.precio);
        ((TextView) findViewById(R.id.stock)).setText(stock);
        ((TextView) findViewById(R.id.detalleProducto)).setText(product.details);
        ((TextView) findViewById(R.id.cantidadcarrito)).setText(String.valueOf(viewModel.cantidad));
            loadImageFromURL(
                    (ImageView) findViewById(R.id.imagenDetalle),
                    product.picture
            );

        }


    private void loadImageFromURL(ImageView imageView, String imageUrl){
        RequestManager reqManager = Glide.with(imageView.getContext());
        RequestBuilder reqBuilder = reqManager.load(imageUrl);
        RequestOptions reqOptions = new RequestOptions();
        reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        reqBuilder.apply(reqOptions);
        reqBuilder.into(imageView);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, DetalleLogActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
