package es.hotmail.pcasteres.elverol.data;

import java.util.List;

public interface RepositoryContract {

  void deleteProduct(
          ProductItem product, DeleteProductCallback callback);

  void updateProduct(
          ProductItem product, UpdateProductCallback callback);


  void deleteFactura(
          FacturaItem category, DeleteFacturaCallback callback);

  void updateFactura(
          FacturaItem facturaItem, UpdateFacturaCallback callback);

  void deleteCarrito(
          CarritoItem carritoItem, DeleteCarritoCallback callback);

  void updateCarrito(
          CarritoItem carritoItem, UpdateCarritoCallback callback);

  void insertCarrito(CarritoItem carritoItem, InsertCarritoCallback callback);

  void deleteCategory(
          CategoryItem category, DeleteCategoryCallback callback);

  void deleteUser(
          UserItem userItem, DeleteUserCallback callback);

  void updateCategory(
          CategoryItem category, UpdateCategoryCallback callback);

  void updateUser(
          UserItem userItem, UpdateUserCallback callback);

  interface FetchCatalogDataCallback {
    void onCatalogDataFetched(boolean error);
  }

  interface GetProductListCallback {
    void setProductList(List<ProductItem> products);
  }

  interface GetAllProductListCallback {

    //void setAllProducts(List<ProductItem> products);

    void setAllProductList(List<MinProductItem> products);
  }


  interface GetProductDataCallback {
    void setProductData(ProductItem item);
  }

  interface GetProductPrecioCallback {
    void setProductPrecio(String a);
  }

  interface GetCarritoListCallback {
    void setCarritoList(List<CarritoItem> products);
  }

  interface GetCarritoItemCallback {
    void setCarritoItem(CarritoItem product);
  }

  interface GetProductCallback {
    void setProduct(ProductItem product);
  }

  interface GetFacturaCallback {
    void setFactura(FacturaItem factura);
  }

  interface GetUserCallback {
    void setUser(UserItem user);
  }

  interface GetCategoryListCallback {
    void setCategoryList(List<CategoryItem> categories);
  }

  interface GetCategoryCallback {
    void setCategory(CategoryItem category);
  }

  interface DeleteCategoryCallback {
    void onCategoryDeleted();
  }

  interface UpdateCategoryCallback {
    void onCategoryUpdated();
  }

  interface DeleteProductCallback {
    void onProductDeleted();
  }

  interface UpdateProductCallback {
    void onProductUpdated();
  }

  interface DeleteFacturaCallback {
    void onFacturaDeleted();
  }

  interface UpdateFacturaCallback {
    void onFacturaUpdated();
  }

  interface DeleteCarritoCallback {
    void onCarritoDeleted();
  }

  interface UpdateCarritoCallback {
    void onCarritoUpdated();
  }

  interface InsertCarritoCallback {

    void onCarritoInsert();

  }

  interface DeleteUserCallback {
    void onUserDeleted();
  }

  interface UpdateUserCallback {
    void onUserUpdated();
  }





  void loadCatalog(boolean clearFirst, FetchCatalogDataCallback callback);

  void getProductList(
          CategoryItem category, CatalogRepository.GetProductListCallback callback);

  void getProductList(int categoryId, CatalogRepository.GetProductListCallback callback);

  void getAllProductList(int id,CatalogRepository.GetAllProductListCallback callback);

  void getProductData(int id, GetProductDataCallback callback);

  void getcarritoList(
          FacturaItem facturaItem, GetCarritoListCallback callback);

  void getcarritoList(
          int facturaId, GetCarritoListCallback callback);

  void getcarritoList(
          GetCarritoListCallback callback);

    void getcarritoItem(int i, int a,
                        GetCarritoItemCallback callback);

    void getProduct(int id, CatalogRepository.GetProductCallback callback);

  void getFactura(int id, GetFacturaCallback callback);

  void getUser(String usuario, String password, GetUserCallback callback);

  void getCategory(int id, CatalogRepository.GetCategoryCallback callback);
  void getCategoryList(CatalogRepository.GetCategoryListCallback callback);

}
