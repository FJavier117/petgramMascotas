package f_mendez07.blogspot.com.petagram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static androidx.appcompat.widget.Toolbar.*;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miToolBar();

        listaMascotas = findViewById(R.id.rcvMascotas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(linearLayoutManager);
        inicializarLista();
        inicializarAdaptador();


    }

    public void miToolBar(){
        Toolbar miActionBarMain = findViewById(R.id.miToolBar);
        miActionBarMain.inflateMenu(R.menu.menu);

        final ImageButton imgbActionTb = miActionBarMain.findViewById(R.id.imgbActionTb);

        imgbActionTb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Mascotas favoritas",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MascotasFavoritos.class);
                startActivity(intent);
                //finish();
            }
        });

    }

    public void inicializarAdaptador(){
        MascotasAdapter mascotasAdapter = new MascotasAdapter(mascotas, this);
        listaMascotas.setAdapter(mascotasAdapter);
    }

    public void inicializarLista(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascotas(R.drawable.leon,getResources().getString(R.string.leon),"5"));
        mascotas.add(new Mascotas(R.drawable.perro1,getResources().getString(R.string.perro),"3"));
        mascotas.add(new Mascotas(R.drawable.cebra,getResources().getString(R.string.cebra),"3"));
        mascotas.add(new Mascotas(R.drawable.lobo,getResources().getString(R.string.lobo),"2"));
        mascotas.add(new Mascotas(R.drawable.oso,getResources().getString(R.string.oso),"1"));
    }
}
