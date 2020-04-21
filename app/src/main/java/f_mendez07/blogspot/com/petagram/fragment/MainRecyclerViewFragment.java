package f_mendez07.blogspot.com.petagram.fragment;

import android.content.Context;
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

import f_mendez07.blogspot.com.petagram.pojo.Mascotas;
import f_mendez07.blogspot.com.petagram.R;
import f_mendez07.blogspot.com.petagram.adapter.MascotasAdapter;
import f_mendez07.blogspot.com.petagram.presentador.IPresentador;
import f_mendez07.blogspot.com.petagram.presentador.Presentador;

public class MainRecyclerViewFragment extends Fragment implements IMainRecyclerViewFragmentView {
    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private Context mContext;

    private IPresentador presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reciclerview_main,container,false);
        listaMascotas = v.findViewById(R.id.rcvMascotas);

        presenter = new Presentador(this,getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotasAdapter crearAdaptador(ArrayList<Mascotas> mascotas) {
        return new MascotasAdapter(mascotas,getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(MascotasAdapter adapter) {
        listaMascotas.setAdapter(adapter);
    }
}
