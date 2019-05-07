package es.hotmail.pcasteres.elverol.data;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "categories")
public class CategoryItem {
  @PrimaryKey
  public int id;

  public String content;
  public String image;
  @Ignore
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
