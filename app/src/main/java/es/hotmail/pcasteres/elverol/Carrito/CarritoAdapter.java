package es.hotmail.pcasteres.elverol.Carrito;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.data.CarritoItem;

public class CarritoAdapter
        extends RecyclerView.Adapter<CarritoAdapter.ViewHolder> {

  private List<CarritoItem> itemList;
  private final View.OnClickListener clickListener;




  public CarritoAdapter(View.OnClickListener listener) {

    itemList = new ArrayList();
    clickListener = listener;
  }


  public void addItem(CarritoItem item){
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<CarritoItem> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<CarritoItem> items){
    itemList = items;
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.carrito_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);
    holder.contentView.setText(itemList.get(position).cantidad);

  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contentView;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.cantidadcarrito);

    }
  }
  //Código que permite añadir imágenes faltan los import, que no consigo que funcionen
}
