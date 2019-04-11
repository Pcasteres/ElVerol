package es.hotmail.pcasteres.elverol.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CategoryItem {

  public int id;

  public String content;
  public String image;

  @SerializedName("products")
  public List<ProductItem> items;

  @Override
  public String toString() {
    return content;
  }

  public int getId() {
    return id;
  }

  public String getImage() {
    return image;
  }

  public CategoryItem(int id, String content, String image) {
    this.id = id;
    this.content = content;
    this.image= image;
  }
}
