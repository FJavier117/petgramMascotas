package f_mendez07.blogspot.com.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.Collections;

import f_mendez07.blogspot.com.petagram.adapter.MascotasAdapter;
import f_mendez07.blogspot.com.petagram.adapter.MascotasCincoFavAdapter;
import f_mendez07.blogspot.com.petagram.db.BaseDeDatos;
import f_mendez07.blogspot.com.petagram.db.ConstantesDB;
import f_mendez07.blogspot.com.petagram.db.ConstructorDeMascotas;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

public class MascotasCincoFav extends AppCompatActivity {

    ArrayList<Mascotas> arraylistMascotaFv;
    RecyclerView recyclerViewMascotasFv;
    Activity mActivity;
    BaseDeDatos conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritos);


        Toolbar toolbar = findViewById(R.id.miToolBarDos);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        conn=new BaseDeDatos(mActivity);
        arraylistMascotaFv = new ArrayList<>();


        recyclerViewMascotasFv = findViewById(R.id.rcvMascotasFavoritas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMascotasFv.setLayoutManager(linearLayoutManager);
        obteberLasMascotas();
        MascotasCincoFavAdapter adapter = new MascotasCincoFavAdapter(arraylistMascotaFv,mActivity);
        recyclerViewMascotasFv.setAdapter(adapter);




    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(MascotasCincoFav.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    /*public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMascotasFv.setLayoutManager(linearLayoutManager);
    }

    public MascotasCincoFavAdapter crearAdaptador(ArrayList<Mascotas> mascotas) {
        return new MascotasCincoFavAdapter(mascotas,mActivity);
    }

  public void inicializarAdaptador(){
        MascotasCincoFavAdapter mascotasCincoFavAdapter = new MascotasCincoFavAdapter(arraylistMascotaFv,mActivity);
        recyclerViewMascotasFv.setAdapter(mascotasCincoFavAdapter);}


    public void inicializarAdaptadorFavoritos(MascotasCincoFavAdapter adapter) {
        rvMascotasFavoritas.setAdapter(adapter);
    }


   public void inicializarLista(){
        //arraylistMascotaFv = new ArrayList<>();
       listaMascotasFavoritas.add(new Mascotas(R.drawable.perro1,getResources().getString(R.string.perro),4));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.leon,getResources().getString(R.string.leon),3));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.perro1,getResources().getString(R.string.perro),4));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.cebra,getResources().getString(R.string.cebra),4));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.lobo,getResources().getString(R.string.lobo),7));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.oso,getResources().getString(R.string.oso),9));
    }*/

    //////////////////////////////////////////////////////////////////////////////////

    //creamos un metodo para obtener a todas las mascotas retorna un array de mascotas
    public void obteberLasMascotas(){
        //ArrayList<Mascotas> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesDB.TABLE_PETS;
        SQLiteDatabase db = conn.getReadableDatabase();
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
            arraylistMascotaFv.add(mascotasActual);
            registroLikes.close();
        }
        db.close();
        registros.close();
        //return  arraylistMascotaFv;
    }










    public void imprimeFavoritos() {
        ArrayList<Mascotas> listaMascota;
        arraylistMascotaFv = new ArrayList<>();

        ConstructorDeMascotas constructorDeMascotas = new ConstructorDeMascotas(mActivity);

        listaMascota = constructorDeMascotas.obtenerMascotas();

        //ArrayList<Mascotas> aux2 = new ArrayList<>();

        Collections.sort(listaMascota,new ComparaLikesMascotas());

        for(int i = 0; i<listaMascota.size();i++) {
            if(i<=4) {
                arraylistMascotaFv.add(listaMascota.get(i));
            }
        }

   /* for(int i = 0; i<aux2.size();i++) {
        System.out.print(aux2.get(i));

    }*/
   //return arraylistMascotaFv;

    }

/////////////////////////////////////////////////////////////////////////////////////







}
