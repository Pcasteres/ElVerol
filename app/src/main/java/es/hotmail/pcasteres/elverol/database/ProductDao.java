package es.hotmail.pcasteres.elverol.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.hotmail.pcasteres.elverol.data.MinProductItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;

@Dao
public interface ProductDao {


  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertProduct(ProductItem product);

  @Update
  void updateProduct(ProductItem product);

  @Delete
  void deleteProduct(ProductItem product);

  @Query("SELECT * FROM products")
  List<ProductItem> loadProducts();

  @Query("SELECT * FROM products WHERE category_id = :id LIMIT 1")
  ProductItem loadProduct(int id);

  @Query("SELECT * FROM products WHERE id= :id LIMIT 1")
  ProductItem loadProductData(int id);

  @Query("SELECT * FROM products WHERE category_id=:categoryId")
  List<ProductItem> loadProducts(final int categoryId);

  @Query("SELECT id, name, precio FROM products INNER JOIN carritos ON products.id=carritos.idObjeto and carritos.idFactura=:idfac")
  List<MinProductItem> loadProductss(int idfac);

  @Query("SELECT precio FROM products WHERE id=:id")
  String loadProductPrecio(int id);
}
