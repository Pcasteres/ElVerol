package es.hotmail.pcasteres.elverol.ListaProductosLog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class ListaProductosLogAdapter
        extends RecyclerView.Adapter<ListaProductosLogAdapter.ViewHolder> {

  private List<ProductItem> itemList;
  private final View.OnClickListener clickListener;


  public ListaProductosLogAdapter(View.OnClickListener listener) {

    itemList = new ArrayList();
    clickListener = listener;
  }


  public void addItem(ProductItem item){
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<ProductItem> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<ProductItem> items){
    itemList = items;
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.product_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);
    holder.contentView.setText(itemList.get(position).name);
    loadImageFromURL(
            (holder.imageView), itemList.get(position).picture    );
  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contentView;
    final ImageView imageView;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.content);
      imageView = view.findViewById(R.id.imagen1);

    }
  }
  //Código que permite añadir imágenes faltan los import, que no consigo que funcionen
  private void loadImageFromURL(ImageView imageView, String imageUrl){
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }
}
