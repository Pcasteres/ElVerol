package es.hotmail.pcasteres.elverol.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "Facturas",
        foreignKeys = @ForeignKey(
                entity = UserItem.class,
                parentColumns = "idUser",
                childColumns = "idUser",
                onDelete = CASCADE
        )
)
public class FacturaItem {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int idUser;
    public String estado;
    public String total;

    @Ignore
    @SerializedName("Carritos")
    public List<CarritoItem> items;
}
