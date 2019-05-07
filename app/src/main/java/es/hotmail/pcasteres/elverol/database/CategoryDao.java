package es.hotmail.pcasteres.elverol.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.hotmail.pcasteres.elverol.data.CategoryItem;

@Dao
public interface CategoryDao {


  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertCategory(CategoryItem category);

  @Update
  void updateCategory(CategoryItem category);

  @Delete
  void deleteCategory(CategoryItem category);

  @Query("SELECT * FROM categories")
  List<CategoryItem> loadCategories();

  @Query("SELECT * FROM categories WHERE id = :id LIMIT 1")
  CategoryItem loadCategory(int id);
}
