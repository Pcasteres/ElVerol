package es.hotmail.pcasteres.elverol.data;

public class ProductItem {
  public int idProducts;
  public String name;
  public String details;
  public String picture;
  public String precio;
  public int categoryId;
  public int Stock;



  @Override
  public String toString() {
    return name;
  }
}