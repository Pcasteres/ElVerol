package es.hotmail.pcasteres.elverol.PrincipalNoLog;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.hotmail.pcasteres.elverol.R;
import es.hotmail.pcasteres.elverol.data.CategoryItem;

public class PrincipalNoLogAdapter
    extends RecyclerView.Adapter<PrincipalNoLogAdapter.ViewHolder> {

  private List<CategoryItem> itemList;
  private final View.OnClickListener clickListener;


  public PrincipalNoLogAdapter(View.OnClickListener listener) {

    itemList = new ArrayList();
    clickListener = listener;
  }

  public void addItem(CategoryItem item){
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<CategoryItem> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<CategoryItem> items){
    itemList = items;
    notifyDataSetChanged();
  }




  @Override
  public int getItemCount() {
    return itemList.size();
  }


  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.category_list_content, parent, false);
    return new ViewHolder(view);
  }
  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);
    holder.contentView.setText(itemList.get(position).content);
    holder.imageView.setImageDrawable(Drawable.createFromPath(itemList.get(position).image));
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contentView;
    final ImageView imageView;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.content);
      imageView = view.findViewById(R.id.imagen);
      
    }
  }
}
