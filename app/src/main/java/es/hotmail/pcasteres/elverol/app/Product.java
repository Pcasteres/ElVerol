package es.hotmail.pcasteres.elverol.app;

public class Product {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Float precio;
    private String idcategoria;

    public Product(int id, String nombre, Float precio, String descripcion, String imagen, String idcategoria) {
        this.id=id;
        this.descripcion=descripcion;
        this.imagen=imagen;
        this.precio=precio;
        this.nombre=nombre;
        this.idcategoria=idcategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
