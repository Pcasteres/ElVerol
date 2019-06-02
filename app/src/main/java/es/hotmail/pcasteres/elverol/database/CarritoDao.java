package es.hotmail.pcasteres.elverol.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.hotmail.pcasteres.elverol.data.CarritoItem;

@Dao
public interface CarritoDao {


  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertCarrito(CarritoItem carritoItem);

  @Update
  void updateCarrito(CarritoItem carritoItem);

  @Delete
  void deleteCarrito(CarritoItem carritoItem);

  @Query("SELECT * FROM Carritos WHERE idCarrito = :id LIMIT 1")
  CarritoItem loadCarrito(int id);

  @Query("SELECT * FROM Carritos WHERE idObjeto = :id and idFactura = :fac LIMIT 1")
  CarritoItem loadCarritoit(int id, int fac);

  @Query("SELECT * FROM Carritos WHERE idFactura=:factura_Id")
  List<CarritoItem> loadCarritos(final int factura_Id);

  @Query("SELECT * FROM Carritos WHERE idFactura=1")
  List<CarritoItem> loadCarritos();
  

}
