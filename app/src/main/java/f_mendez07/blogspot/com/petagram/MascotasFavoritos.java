package f_mendez07.blogspot.com.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.ArrayList;

public class MascotasFavoritos extends AppCompatActivity {

    ArrayList<Mascotas>  listaMascotasFavoritas;
    RecyclerView rvMascotasFavoritas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritos);

        Toolbar toolbar = findViewById(R.id.miToolBarDos);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        rvMascotasFavoritas = findViewById(R.id.rcvMascotasFavoritas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvMascotasFavoritas.setLayoutManager(linearLayoutManager);
        inicializarLista();
        inicializarAdaptador();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(MascotasFavoritos.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void inicializarAdaptador(){
        MascotasAdapter mascotasAdapter = new MascotasAdapter(listaMascotasFavoritas, this);
        rvMascotasFavoritas.setAdapter(mascotasAdapter);
    }

    public void inicializarLista(){
        listaMascotasFavoritas = new ArrayList<>();
        listaMascotasFavoritas.add(new Mascotas(R.drawable.leon,getResources().getString(R.string.leon),"5"));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.perro1,getResources().getString(R.string.perro),"3"));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.cebra,getResources().getString(R.string.cebra),"3"));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.lobo,getResources().getString(R.string.lobo),"2"));
        listaMascotasFavoritas.add(new Mascotas(R.drawable.oso,getResources().getString(R.string.oso),"3"));
    }



}
