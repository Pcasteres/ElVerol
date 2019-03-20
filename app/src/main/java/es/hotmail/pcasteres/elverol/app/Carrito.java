package es.hotmail.pcasteres.elverol.app;

public class Carrito {

private int id;
private int compra;
private int product_id;
private int cantidad;
private int User_id;

    public Carrito(int id, int compra, int product_id, int cantidad, int user_id) {
        this.id = id;
        this.compra = compra;
        this.product_id = product_id;
        this.cantidad = cantidad;
        User_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }
}
