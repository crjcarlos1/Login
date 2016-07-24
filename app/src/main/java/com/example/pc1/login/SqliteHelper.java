package com.example.pc1.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pc1 on 23/07/2016.
 */
public class SqliteHelper extends SQLiteOpenHelper
{
    private static final int versionDB=1;

    public static final String nombreDB="login.sqlite",
                                nombreTabla="datos",
                                campoId="id",
                                campoNombres="nombres",
                                campoApellidos="apellidos",
                                campoCorreo="correo",
                                campoTelefono="telefono",
                                campoEdad="edad";

    private String crearTabla="CREATE TABLE "+nombreTabla+"("
                              +campoId+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                              +campoNombres+" TEXT NOT NULL,"
                              +campoApellidos+" TEXT NOT NULL,"
                              +campoCorreo+" TEXT NOT NULL,"
                              +campoTelefono+" TEXT NOT NULL,"
                              +campoEdad+" TEXT NOT NULL);";

    public SqliteHelper(Context context) {
        super(context,nombreDB,null, versionDB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(crearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static ContentValues getContentValues(String nombres,String apellidos,String correo,String telefono,String edad)
    {
        ContentValues valores=new ContentValues();
        valores.put(campoNombres,nombres);
        valores.put(campoApellidos,apellidos);
        valores.put(campoCorreo,correo);
        valores.put(campoTelefono,telefono);
        valores.put(campoEdad,edad);
        return valores;
    }

}
