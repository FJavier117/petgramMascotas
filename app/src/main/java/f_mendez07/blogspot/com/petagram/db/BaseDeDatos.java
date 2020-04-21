package f_mendez07.blogspot.com.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

public class BaseDeDatos extends SQLiteOpenHelper {

    private Context mContext;
     //constructor de la clase BaseDeDatos recibe el contexto como parametro
    public BaseDeDatos(@Nullable Context mContext) {
        super(mContext, ConstantesDB.DATABASE_NAME, null, ConstantesDB.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos la base de datos de las mascotas con las tablas consulta (query) tabla mascota
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesDB.TABLE_PETS + "("+
                ConstantesDB.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLE_PETS_NAME + " TEXT, " +
                ConstantesDB.TABLE_PETS_FOTO + " INTEGER" +
        ")";

        //creamos la base de datos de los likes con las tablas consulta (query) tabla likes mascota
        String queryCreaTablaLikesMascotas = "CREATE TABLE " + ConstantesDB.TABLE_LIKES_PETS + "(" +
                ConstantesDB.TABLE_LIKES_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLE_LIKES_PETS_ID_PET + " INTEGER, " +
                ConstantesDB.TABLE_LIKES_PETS_NUMERO_LIKES + " INTEGER, " +
                //enlazamos ambas tablas mediante FOREIGN KEY y REFERENCES
                "FOREIGN KEY (" + ConstantesDB.TABLE_LIKES_PETS_ID_PET + ") " +
                "REFERENCES " + ConstantesDB.TABLE_PETS + "(" + ConstantesDB.TABLE_PETS_ID + ")" +
                ")";
        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCreaTablaLikesMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //execSQL cuando el método no retorna ningun dato
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDB.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDB.TABLE_LIKES_PETS);
        //recibe una base de datos
        onCreate(db);
    }


    //creamos un metodo para obtener a todas las mascotas retorna un array de mascotas
    public ArrayList<Mascotas> obteberTodasLasMascotas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesDB.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascotas mascotasActual = new Mascotas();
            mascotasActual.setId(registros.getInt(0));
            mascotasActual.setNombreMascota(registros.getString(1));
            mascotasActual.setImgFoto(registros.getInt(2));

            String queryLikesMascotas = "SELECT COUNT(" + ConstantesDB.TABLE_LIKES_PETS_NUMERO_LIKES + ") as likes" +
                    " FROM " + ConstantesDB.TABLE_LIKES_PETS +
                    " WHERE " + ConstantesDB.TABLE_LIKES_PETS_ID_PET + "=" + mascotasActual.getId();
            Cursor registroLikes = db.rawQuery(queryLikesMascotas,null);
            if (registroLikes.moveToNext()){
                mascotasActual.setLikes(registroLikes.getInt(0));
            }else {
                mascotasActual.setLikes(0);
            }
            mascotas.add(mascotasActual);
            registroLikes.close();
        }
        db.close();
        registros.close();
        return  mascotas;
    }

    //metodo que sirve para insertar las mascotas  a la base de datos
    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_PETS,null, contentValues);
        db.close();
    }

    //metodo que sirve para insertar los likes  a la base de datos
    public void insertarLikes(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_LIKES_PETS,null,contentValues);
        db.close();
    }

    public int obternerLikesMascotas(Mascotas mascota){
        int likes =0;
        String query = "SELECT COUNT(" + ConstantesDB.TABLE_LIKES_PETS_NUMERO_LIKES+ ")" +
                " FROM " + ConstantesDB.TABLE_LIKES_PETS +
                " WHERE " + ConstantesDB.TABLE_LIKES_PETS_ID_PET + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        registros.close();
        db.close();
        return likes;
    }


}
