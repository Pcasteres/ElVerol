package es.hotmail.pcasteres.elverol.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import es.hotmail.pcasteres.elverol.database.CarritoDao;
import es.hotmail.pcasteres.elverol.database.CatalogDatabase;
import es.hotmail.pcasteres.elverol.database.CategoryDao;
import es.hotmail.pcasteres.elverol.database.FacturaDao;
import es.hotmail.pcasteres.elverol.database.ProductDao;
import es.hotmail.pcasteres.elverol.database.UserDao;



public class CatalogRepository implements RepositoryContract {

  public static String TAG = CatalogRepository.class.getSimpleName();

  public static final String DB_FILE = "catalog.db";
  public static final String JSON_FILE = "Verol.json";
  public static final String JSON_ROOT_cat = "categories";
  public static final String JSON_ROOT_us = "Users";
  public static final String JSON_ROOT_fac = "Facturas";

  private static CatalogRepository INSTANCE;


  private CatalogDatabase database;
  private Context context;

  private List<CategoryItem> categories;
  private List<FacturaItem> facturaItems;
  private List<UserItem> userItems;


  public static RepositoryContract getInstance(Context context) {
    if(INSTANCE == null){
      INSTANCE = new CatalogRepository(context);
    }

    return INSTANCE;
  }

  private CatalogRepository(Context context) {
    this.context = context;
    //categories = new ArrayList();

    database = Room.databaseBuilder(
            context, CatalogDatabase.class, DB_FILE
    ).build();
  }

    @Override
  public void loadCatalog(final boolean clearFirst, final FetchCatalogDataCallback callback) {

    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if(clearFirst) {
          database.clearAllTables();
        }

        boolean error = false;
        if(getCategoryDao().loadCategories().size() == 0 ) {
          error = !loadCatalogFromJSON(loadJSONFromAsset());
        }

        if(callback != null) {
          callback.onCatalogDataFetched(error);
        }
      }
    });

  }

  @Override
  public void getProductList(
          final CategoryItem category, final GetProductListCallback callback) {

    getProductList(category.id, callback);
  }


  @Override
  public void getProductList(
          final int categoryId, final GetProductListCallback callback) {

    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if(callback != null) {
          callback.setProductList(getProductDao().loadProducts(categoryId));
        }
      }
    });

  }

  @Override
  public void getProductName(final int id, final GetProductName callback){

      AsyncTask.execute(new Runnable() {

          @Override
          public void run() {
              if(callback != null) {
                  callback.setProductName(getProductDao().loadProductName(id));
              }
          }
      });

  }
    @Override
    public void getcarritoList(
            final FacturaItem facturaItem, final GetCarritoListCallback callback) {

        getcarritoList(facturaItem.idFactura, callback);
    }

  @Override
  public void getcarritoList(
          final int facturaId, final GetCarritoListCallback callback) {

    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if(callback != null) {

          callback.setCarritoList(getCarritoDao().loadCarritos(facturaId));
        }
      }
    });

  }





  @Override
  public void getProduct(final int id, final GetProductCallback callback) {

      AsyncTask.execute(new Runnable() {

          @Override
          public void run() {
              if(callback != null) {
                  callback.setProduct(getProductDao().loadProduct(id));
              }
          }
      });
  }


  @Override
  public void getFactura(final int id, final GetFacturaCallback callback) {

      AsyncTask.execute(new Runnable() {

          @Override
          public void run() {
              if(callback != null) {
          callback.setFactura(getFacturaDao().loadFactura(id));
        }
      }
    });
  }

  @Override
  public void getUser(final String usuario, final String password, final GetUserCallback callback) {

      AsyncTask.execute(new Runnable() {

          @Override
          public void run() {
              if(callback != null) {
          callback.setUser(getUserDao().loadUser(password,usuario));
        }
      }
    });
  }



  @Override
  public void getCategory(final int id, final GetCategoryCallback callback) {

      AsyncTask.execute(new Runnable() {

          @Override
          public void run() {
              if(callback != null) {
                  callback.setCategory(getCategoryDao().loadCategory(id));
              }
          }
      });

  }




  @Override
  public void getCategoryList(final GetCategoryListCallback callback) {
      AsyncTask.execute(new Runnable() {

          @Override
          public void run() {
              if(callback != null) {
          callback.setCategoryList(getCategoryDao().loadCategories());
        }
      }
    });

  }

    @Override
    public void deleteProduct(
            final ProductItem product, final DeleteProductCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getProductDao().deleteProduct(product);
                    callback.onProductDeleted();
                }
            }
        });
    }

    @Override
    public void updateProduct(
            final ProductItem product, final UpdateProductCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getProductDao().updateProduct(product);
                    callback.onProductUpdated();
                }
            }
        });
    }


    @Override
    public void deleteCategory(
            final CategoryItem category, final DeleteCategoryCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getCategoryDao().deleteCategory(category);
                    callback.onCategoryDeleted();
                }
            }
        });
    }

    @Override
    public void updateCategory(
            final CategoryItem category, final UpdateCategoryCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getCategoryDao().updateCategory(category);
                    callback.onCategoryUpdated();
                }
            }
        });
    }

    @Override
    public void deleteFactura(
            final FacturaItem category, final DeleteFacturaCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getFacturaDao().deleteFactura(category);
                    callback.onFacturaDeleted();
                }
            }
        });
    }

    @Override
    public void updateFactura(
            final FacturaItem facturaItem, final UpdateFacturaCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getFacturaDao().updateFactura(facturaItem);
                    callback.onFacturaUpdated();
                }
            }
        });
    }

    @Override
    public void deleteCarrito(
            final CarritoItem carritoItem, final DeleteCarritoCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getCarritoDao().deleteCarrito(carritoItem);
                    callback.onCarritoDeleted();
                }
            }
        });
    }

    @Override
    public void updateCarrito(
            final CarritoItem carritoItem, final UpdateCarritoCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getCarritoDao().updateCarrito(carritoItem);
                    callback.onCarritoUpdated();
                }
            }
        });
    }

    @Override
    public void deleteUser(
            final UserItem userItem, final DeleteUserCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getUserDao().deleteUser(userItem);
                    callback.onUserDeleted();
                }
            }
        });
    }

    @Override
    public void updateUser(
            final UserItem userItem, final UpdateUserCallback callback) {

        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    getUserDao().updateUser(userItem);
                    callback.onUserUpdated();
                }
            }
        });
    }

    private CategoryDao getCategoryDao() {
        return database.categoryDao();
    }

    private ProductDao getProductDao() {
        return database.productDao();
    }

    private CarritoDao getCarritoDao() {
        return database.carritoDao();
    }

    private UserDao getUserDao() {
        return database.userDao();
    }

    private FacturaDao getFacturaDao() {
        return database.facturaDao();
    }

  private boolean loadCatalogFromJSON(String json) {
    Log.e(TAG, "loadCatalogFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArraycat = jsonObject.getJSONArray(JSON_ROOT_cat);
      JSONArray jsonArrayus = jsonObject.getJSONArray(JSON_ROOT_us);
      JSONArray jsonArrayfac = jsonObject.getJSONArray(JSON_ROOT_fac);

      // array categorias
        if (jsonArraycat.length() > 0) {

            final List<CategoryItem> categories = Arrays.asList(
                    gson.fromJson(jsonArraycat.toString(), CategoryItem[].class)
            );

            for (CategoryItem category: categories) {
                getCategoryDao().insertCategory(category);
            }

            for (CategoryItem category: categories) {
                for (ProductItem product: category.items) {
                    product.categoryId = category.id;
                    getProductDao().insertProduct(product);
                }
            }

            return true;
        }

      // array usuarios
        if (jsonArrayus.length() > 0) {

            final List<UserItem> users = Arrays.asList(
                    gson.fromJson(jsonArrayus.toString(), UserItem[].class)
            );

            for (UserItem userItem: users) {
                getUserDao().insertUser(userItem);
            }

            return true;
        }
      // array factura
        if (jsonArrayfac.length() > 0) {

            final List<FacturaItem> facturaItems= Arrays.asList(
                    gson.fromJson(jsonArrayfac.toString(), FacturaItem[].class)
            );

            for (FacturaItem facturaItem: facturaItems) {
                getFacturaDao().insertFactura(facturaItem);
            }

            for (FacturaItem facturaItem: facturaItems) {
                for (CarritoItem carritoItem: facturaItem.items) {
                    carritoItem.factura_id = facturaItem.idFactura;
                    getCarritoDao().insertCarrito(carritoItem);
                }
            }

            return true;
        }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }



  private String loadJSONFromAsset() {
    //Log.e(TAG, "loadJSONFromAsset()");

    String json = null;

    try {

      InputStream is = context.getAssets().open(JSON_FILE);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");

    } catch (IOException error) {
      Log.e(TAG, "error: " + error);
    }

    return json;
  }

}

