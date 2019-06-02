package es.hotmail.pcasteres.elverol.Carrito;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.MinProductItem;

public class CarritoAdapter
        extends RecyclerView.Adapter<CarritoAdapter.ViewHolder> {

  public static String TAG = CarritoAdapter.class.getSimpleName();
  private List<CarritoItem> itemList;
  private List<MinProductItem> itemList2;
  private CarritoContract.Presenter presenter;
  private CarritoViewModel viewModel;
  private final View.OnClickListener clickListener;




  public CarritoAdapter(View.OnClickListener listener) {

    itemList = new ArrayList();
    itemList2 = new ArrayList();
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
    Log.e(TAG, "setItems()");
  }
  public void setobjects(List<MinProductItem> items){
    itemList2 = items;
    notifyDataSetChanged();
    Log.e(TAG, "setItems2()");
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.carrito_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    Log.e(TAG, "onBindViewHolder()");
    Log.e(TAG, String.valueOf(itemList.get(position).idObjeto));
//    Log.e(TAG, String.valueOf(itemList2.get(position).name));
    holder.itemView.setTag(itemList.get(position));
//    holder.itemView.setOnClickListener(clickListener);
    for (MinProductItem minpro: itemList2){
      if (minpro.id==itemList.get(position).idObjeto){

        holder.contentView0.setText(minpro.name);

      }

    }

    holder.contentView.setText(String.valueOf(itemList.get(position).cantidad));
    holder.eliminar.setTag(itemList.get(position));
    holder.eliminar.setOnClickListener(clickListener);

  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contentView;
    final TextView contentView0;
    final Button eliminar;
    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.cantidadcarrito);
      contentView0 = view.findViewById(R.id.contentcarrito);
      eliminar = view.findViewById(R.id.buttonEliminar);
    }
  }
  //Código que permite añadir imágenes faltan los import, que no consigo que funcionen
}
