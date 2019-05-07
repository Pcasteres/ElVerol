package es.hotmail.pcasteres.elverol.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import es.hotmail.pcasteres.elverol.data.UserItem;

@Dao
public interface UserDao {


  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertUser(UserItem userItem);

  @Update
  void updateUser(UserItem userItem);

  @Delete
  void deleteUser(UserItem userItem);

  @Query("SELECT * FROM Users WHERE password=:pass and usuario=:user LIMIT 1")
  UserItem loadUser(String pass, String user);
}
