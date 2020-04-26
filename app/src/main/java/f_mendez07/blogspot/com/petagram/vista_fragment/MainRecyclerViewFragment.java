package f_mendez07.blogspot.com.petagram.vista_fragment;

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
import f_mendez07.blogspot.com.petagram.presentador.IRecyclerViewFragmentPresenter;
import f_mendez07.blogspot.com.petagram.presentador.RecyclerViewFragmentPresenter;

public class MainRecyclerViewFragment extends Fragment implements IMainRecyclerViewFragmentView {
    private ArrayList<Mascotas> listaMascotas;
    private RecyclerView rvMascotas;
    private Context mContext;

    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reciclerview_main,container,false);
        rvMascotas = v.findViewById(R.id.rcvMascotas);

        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;
    }

    //implementado métodos de la interfaz SE HA CFEADO LA VISTA
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotasAdapter crearAdaptador(ArrayList<Mascotas> listaMascotas) {
        return new MascotasAdapter(listaMascotas,getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(MascotasAdapter adapter) {
        rvMascotas.setAdapter(adapter);
    }
}
