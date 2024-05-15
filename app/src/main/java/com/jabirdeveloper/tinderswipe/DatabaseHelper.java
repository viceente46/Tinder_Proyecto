package com.jabirdeveloper.tinderswipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TindNet.db";
    private static final int DATABASE_VERSION = 2; // Incrementa la versión de la base de datos
    private static final String TABLE_NAME = "Usuario";
    private static final String NEW_TABLE_NAME2 = "Empresa"; // Nuevo nombre de la tabla
    private static final String COL_1 = "ID";
    private static final String COL_2 = "Nombre";
    private static final String COL_3 = "Apellido";
    private static final String COL_4 = "EMAIL";
    private static final String COL_5 = "PASSWORD";
    // Columnas para la tabla Empresa
    private static final String COL_6 = "EmpresaID";
    private static final String COL_7 = "NombreEmpresa";
    private static final String COL_8 = "Direccion";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // Pasa la nueva versión de la base de datos
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Usuario (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Apellido TEXT, EMAIL TEXT, PASSWORD TEXT)");
        db.execSQL("CREATE TABLE " + NEW_TABLE_NAME2 + " (EmpresaID INTEGER PRIMARY KEY AUTOINCREMENT, NombreEmpresa TEXT, Direccion TEXT)"); // Crear la nueva tabla
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("CREATE TABLE " + NEW_TABLE_NAME2 + " (EmpresaID INTEGER PRIMARY KEY AUTOINCREMENT, NombreEmpresa TEXT, Direccion TEXT)"); // Crear la nueva tabla si la versión de la base de datos es menor a 2
        }
    }

    public boolean insertData(String nombre, String apellido, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,nombre);
        contentValues.put(COL_3,apellido);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Usuario WHERE EMAIL=? AND PASSWORD=?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

}