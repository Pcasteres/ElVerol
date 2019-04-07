package es.hotmail.pcasteres.elverol.app;

import android.app.Application;

import es.hotmail.pcasteres.elverol.Carrito.CarritoState;
import es.hotmail.pcasteres.elverol.DetalleLog.DetalleLogState;
import es.hotmail.pcasteres.elverol.DetalleNoLog.DetalleNoLogState;
import es.hotmail.pcasteres.elverol.ListaProductosLog.ListaProductosLogState;
import es.hotmail.pcasteres.elverol.ListaProductosNoLog.ListaProductosNoLogState;
import es.hotmail.pcasteres.elverol.Login.LoginState;
import es.hotmail.pcasteres.elverol.NewUser.NewUserState;
import es.hotmail.pcasteres.elverol.PrincipalLogin.PrincipalLoginState;
import es.hotmail.pcasteres.elverol.PrincipalNoLog.PrincipalNoLogState;
import es.hotmail.pcasteres.elverol.data.CategoryItem;
import es.hotmail.pcasteres.elverol.data.ProductItem;

public class AppMediator extends Application {

    private PrincipalNoLogState principalNoLogState = new PrincipalNoLogState();
    private PrincipalLoginState principalLoginState = new PrincipalLoginState();
    private NewUserState newUserState = new NewUserState();
    private LoginState loginState = new LoginState();
    private DetalleNoLogState detalleNoLogState = new DetalleNoLogState();
    private DetalleLogState detalleLogState = new DetalleLogState();
    private ListaProductosNoLogState listaProductosNoLogState = new ListaProductosNoLogState();
    private ListaProductosLogState listaProductosLogState = new ListaProductosLogState();
    private CarritoState carritoState = new CarritoState();

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    private int categoria;
    //private Product product;
    private User user;
    private Carrito carrito;
    private CategoryItem category;
    private ProductItem product;

    public PrincipalLoginState getPrincipalLoginState() {
        return principalLoginState;
    }

    public PrincipalNoLogState getPrincipalNoLogState() {
        return principalNoLogState;
    }

    public NewUserState getNewUserState() {
        return newUserState;
    }

    public LoginState getLoginState() {
        return loginState;
    }

    public DetalleLogState getDetalleLogState() {
        return detalleLogState;
    }

    public DetalleNoLogState getDetalleNoLogState() {
        return detalleNoLogState;
    }

    public ListaProductosLogState getListaProductosLogState() {
        return listaProductosLogState;
    }

    public ListaProductosNoLogState getListaProductosNoLogState() { return listaProductosNoLogState; }

    public CarritoState getCarritoState() { return carritoState; }

    public CategoryItem getCategory() {
        return category;
    }

    public void setCategory(CategoryItem category) {
        this.category = category;
    }

    public ProductItem getProduct() {
        ProductItem item = product;
        //product = null;
        return item;
    }


    public void setProduct(ProductItem item) {
        product = item;
    }

    public User getUser() {
        User item = user;
        //product = null;
        return item;
    }


    public void setUser(User item) { user= item; }



    public Carrito getCarrito() {
        Carrito item = carrito;
        //product = null;
        return item;
    }


    public void setCarrito(Carrito item) { carrito= item; }

}

