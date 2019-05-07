package es.hotmail.pcasteres.elverol.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(
        tableName = "products",
        foreignKeys = @ForeignKey(
                entity = CategoryItem.class,
                parentColumns = "id",
                childColumns = "category_id",
                onDelete = CASCADE
        )
)
public class ProductItem {
  @PrimaryKey
  public int id;

  public String name;
  public String picture;
  public String details;
  public String precio;
  public int Stock;

  @ColumnInfo(name = "category_id")
  public int categoryId;


  @Override
  public String toString() {
    return name;
  }
}