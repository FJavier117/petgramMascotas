package f_mendez07.blogspot.com.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;

import f_mendez07.blogspot.com.petagram.ComparaLikesMascotas;
import f_mendez07.blogspot.com.petagram.R;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

public class ConstructorDeMascotas {
    private static final int LIKE = 0;
    private Context mContext;

    public ConstructorDeMascotas(Context mcontext){

        this.mContext = mcontext;
    }

    //método para obtener los datos
    public ArrayList<Mascotas> obtenerMascotas(){
        BaseDeDatos db = new BaseDeDatos(mContext);
        insetarMascotas(db);
        return db.obteberTodasLasMascotas();
    }



    //insertamos mascotas a la base de datos mediante las declaraciones en sql
    public void insetarMascotas(BaseDeDatos db){
        ContentValues contentValues = new ContentValues();

            contentValues.put(ConstantesDB.TABLE_PETS_NAME, "CARLOS");
            contentValues.put(ConstantesDB.TABLE_PETS_FOTO, R.drawable.buho);
            db.insertarMascotas(contentValues);

            contentValues.put(ConstantesDB.TABLE_PETS_NAME, "JUAN");
            contentValues.put(ConstantesDB.TABLE_PETS_FOTO, R.drawable.oso);
            db.insertarMascotas(contentValues);

            contentValues.put(ConstantesDB.TABLE_PETS_NAME, "PEDRO");
            contentValues.put(ConstantesDB.TABLE_PETS_FOTO, R.drawable.leon);
            db.insertarMascotas(contentValues);

    }

    //método para dar likes a las mascotas estos se pasan mediante un contenValues y se reciben en la clase base de datos
    public void darLikesMascotas(Mascotas mascotas){
        BaseDeDatos db = new BaseDeDatos(mContext);
        ContentValues contentValues = new ContentValues();
        //insertamos el identificador de la mascota
        contentValues.put(ConstantesDB.TABLE_LIKES_PETS_ID_PET,mascotas.getId());
        //insertamos los likes alas mascotas iniciando en cero
        contentValues.put(ConstantesDB.TABLE_LIKES_PETS_NUMERO_LIKES,LIKE);

        db.insertarLikes(contentValues);
    }

    //Obtenemos los like que han recibido las mascotas estos se pasan mediante un contenValues y se reciben en la clase base de datos
    public int obternerLikesMascotas(Mascotas mascotas){
        BaseDeDatos db = new BaseDeDatos(mContext);
        return db.obternerLikesMascotas(mascotas);
    }


}
