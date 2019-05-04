package es.hotmail.pcasteres.elverol.data;

public class UserItem {
    public int id;
    public String nombre;
    public String usuario;
    public String password;
    public String municipio;
    public int telefono;
    public String direccion;
    public String correo;
    public int postcode;

    @Override
    public String toString() {
        return nombre;
    }
}
