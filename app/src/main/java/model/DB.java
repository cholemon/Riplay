package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ripley";

    private final String ciudad  = "CREATE TABLE ciudad (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre_ciudad TEXT, latitud TEXT, longitud TEXT, codigo TEXT)";
    private final String errors  = "CREATE TABLE errors (hora_fecha TEXT, mensaje TEXT, codigo_ciudad TEXT)";

    public DB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ciudad);
        db.execSQL(errors);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ciudad");
        db.execSQL("DROP TABLE IF EXISTS errors");

        db.execSQL(ciudad);
        db.execSQL(errors);
    }

    public boolean existe_ciudad(String codigo) {

        String countQuery = "SELECT * FROM ciudad WHERE codigo = '" + codigo + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor     = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return (count > 0);
    }

    public boolean guardar_ciudad(Ciudad c){

        SQLiteDatabase db             = this.getWritableDatabase();
        ContentValues nuevaCollection = new ContentValues();

        nuevaCollection.put("nombre_ciudad", c.getNombre_ciudad());
        nuevaCollection.put("latitud", c.getLatitud());
        nuevaCollection.put("longitud", c.getLongitud());
        nuevaCollection.put("codigo", c.getCodigo());
        long result = db.insert("ciudad", null, nuevaCollection);

        if (result == -1)
            return false;

        return true;
    }

    public ArrayList<Ciudad> getDataCiudad(String codigo) {

        ArrayList<Ciudad> ciudad = new ArrayList<>();
        String selectQuery       = "SELECT id, nombre_ciudad, latitud, longitud, codigo FROM ciudad WHERE codigo = '"+ codigo+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor     = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Ciudad c = new Ciudad();
                c.setId(cursor.getInt(cursor.getColumnIndex("id")));
                c.setNombre_ciudad(cursor.getString(cursor.getColumnIndex("nombre_ciudad")));
                c.setLatitud(cursor.getString(cursor.getColumnIndex("latitud")));
                c.setLongitud(cursor.getString(cursor.getColumnIndex("longitud")));
                c.setCodigo(cursor.getString(cursor.getColumnIndex("codigo")));

                ciudad.add(c);
            } while (cursor.moveToNext());
        }

        db.close();

        return ciudad;
    }

    public boolean logError(String timestamp, String mensaje, String ciudad){

        SQLiteDatabase db             = this.getWritableDatabase();
        ContentValues nuevaCollection = new ContentValues();

        nuevaCollection.put("hora_fecha", timestamp);
        nuevaCollection.put("mensaje", mensaje);
        nuevaCollection.put("codigo_ciudad", ciudad);
        long result = db.insert("errors", null, nuevaCollection);

        if (result == -1)
            return false;

        return true;
    }
}