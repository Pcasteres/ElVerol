package es.hotmail.pcasteres.elverol.DetalleLog;

public class DetalleLogModel implements DetalleLogContract.Model {

    public static String TAG = DetalleLogModel.class.getSimpleName();

    public DetalleLogModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
