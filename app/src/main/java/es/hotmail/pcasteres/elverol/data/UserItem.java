package es.hotmail.pcasteres.elverol.data;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Users")
public class UserItem {
    @PrimaryKey(autoGenerate = true)
    public int idUser;
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
