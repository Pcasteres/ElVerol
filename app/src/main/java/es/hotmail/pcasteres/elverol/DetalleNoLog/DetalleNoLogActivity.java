package es.hotmail.pcasteres.elverol.DetalleNoLog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.hotmail.pcasteres.elverol.Login.LoginActivity;
import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class DetalleNoLogActivity
        extends AppCompatActivity implements DetalleNoLogContract.View {

    public static String TAG = DetalleNoLogActivity.class.getSimpleName();

    private DetalleNoLogContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_no_log);
        //Código para eliminar el action bar
        getSupportActionBar().hide();
        @SuppressLint("WrongViewCast") ImageView btn= (ImageView) findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
        // do the setup
        DetalleNoLogScreen.configure(this);

        // do some work
        presenter.fetchDataProduct();
    }


    @Override
    public void injectPresenter(DetalleNoLogContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(DetalleNoLogViewModel viewModel) {

    }


    @Override
    public void displayProductDetailData(DetalleNoLogViewModel viewModel) {
        Log.e(TAG, "displayProductDetailData()");

        // deal with the data
        ProductItem product = viewModel.product;


        ((TextView) findViewById(R.id.nombre)).setText(product.content);
        ((TextView) findViewById(R.id.precio)).setText(product.precio);
        ((TextView) findViewById(R.id.detalleProducto)).setText(product.details);
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
            navigateUpTo(new Intent(this, DetalleNoLogActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
