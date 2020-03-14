package f_mendez07.blogspot.com.petagram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainReciclerViewFragment extends Fragment {
    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reciclerview_main,container,false);

        listaMascotas = v.findViewById(R.id.rcvMascotas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(linearLayoutManager);
        inicializarLista();
        inicializarAdaptador();
        return v;
    }


    public void inicializarAdaptador(){
        MascotasAdapter mascotasAdapter = new MascotasAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(mascotasAdapter);
    }

    public void inicializarLista(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascotas(R.drawable.leon,getResources().getString(R.string.leon),"5"));
        mascotas.add(new Mascotas(R.drawable.perro1,getResources().getString(R.string.perro),"3"));
        mascotas.add(new Mascotas(R.drawable.cebra,getResources().getString(R.string.cebra),"3"));
        mascotas.add(new Mascotas(R.drawable.lobo,getResources().getString(R.string.lobo),"2"));
        mascotas.add(new Mascotas(R.drawable.oso,getResources().getString(R.string.oso),"3"));
        mascotas.add(new Mascotas(R.drawable.buho,getResources().getString(R.string.buho),"1"));
    }


}
