package es.hotmail.pcasteres.elverol.app;

import android.app.Application;
import es.hotmail.pcasteres.elverol.DetalleLog.DetalleLogState;
import es.hotmail.pcasteres.elverol.ListaProductosLog.ListaProductosLogState;
import es.hotmail.pcasteres.elverol.ListaProductosNoLog.ListaProductosNoLogState;
import es.hotmail.pcasteres.elverol.DetalleNoLog.DetalleNoLogState;
import es.hotmail.pcasteres.elverol.Login.LoginState;
import es.hotmail.pcasteres.elverol.NewUser.NewUserState;
import es.hotmail.pcasteres.elverol.PrincipalLogin.PrincipalLoginState;
import es.hotmail.pcasteres.elverol.PrincipalNoLog.PrincipalNoLogState;

public class CatalogMediator extends Application {

    private PrincipalNoLogState principalNoLogState = new PrincipalNoLogState();
    private PrincipalLoginState principalLoginState = new PrincipalLoginState();
    private NewUserState newUserState = new NewUserState();
    private LoginState loginState = new LoginState();
    private DetalleNoLogState detalleNoLogState = new DetalleNoLogState();
    private DetalleLogState detalleLogState = new DetalleLogState();
    private ListaProductosNoLogState listaProductosNoLogState = new ListaProductosNoLogState();
    private ListaProductosLogState listaProductosLogState = new ListaProductosLogState();

    private Product product;
    private User user;

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

    public Product getProduct() {
        Product item = product;
        //product = null;
        return item;
    }


    public void setProduct(Product item) {
        product = item;
    }

    public User getUser() {
        User item = user;
        //product = null;
        return item;
    }


    public void setUser(User item) { user= item; }

}


