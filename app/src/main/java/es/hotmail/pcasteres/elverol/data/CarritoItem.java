package es.hotmail.pcasteres.elverol.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(
        tableName = "Carritos",
        foreignKeys = @ForeignKey(
                    entity = FacturaItem.class,
                    parentColumns = "id",
                    childColumns = "idFactura",
                    onDelete = CASCADE)

)
public class CarritoItem {
    @PrimaryKey(autoGenerate = true)
    public int idCarrito;
    public int idObjeto;
    public int cantidad;
    @ColumnInfo(name = "idFactura")
    public int idFactura;

    public int getIdObjeto() {
        return idObjeto;
    }

}


