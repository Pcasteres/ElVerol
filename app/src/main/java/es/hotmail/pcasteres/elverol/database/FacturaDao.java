package es.hotmail.pcasteres.elverol.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.hotmail.pcasteres.elverol.data.FacturaItem;

@Dao
public interface FacturaDao {


  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertFactura(FacturaItem product);

  @Update
  void updateFactura(FacturaItem product);

  @Delete
  void deleteFactura(FacturaItem product);

  @Query("SELECT * FROM Facturas")
  List<FacturaItem> loadProducts();

  @Query("SELECT * FROM Facturas WHERE id = :idFactura")
  FacturaItem loadFactura(int idFactura);

  @Query("SELECT * FROM Facturas WHERE idUser=:userId")
  List<FacturaItem> loadFacturas(final int userId);

  @Query("SELECT * FROM Facturas WHERE idUser=:userId and estado=\"activa\"")
  FacturaItem loadFacturaActiva(final int userId);
}
