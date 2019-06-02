package es.hotmail.pcasteres.elverol.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import es.hotmail.pcasteres.elverol.data.CarritoItem;
import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.FacturaItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;
import es.hotmail.pcasteres.elverol.data.UserItem;

@Database(entities = {CategoryItem.class, ProductItem.class, FacturaItem.class, UserItem.class, CarritoItem.class}, version = 2)
public abstract class CatalogDatabase extends RoomDatabase {

  public abstract CategoryDao categoryDao();
  public abstract ProductDao productDao();
  public abstract FacturaDao facturaDao();
  public abstract UserDao userDao();
  public abstract CarritoDao carritoDao();
}
