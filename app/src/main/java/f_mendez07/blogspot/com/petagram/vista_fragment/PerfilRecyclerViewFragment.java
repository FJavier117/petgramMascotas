package f_mendez07.blogspot.com.petagram.vista_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.adapter.MascotasPerfilFragment;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;
import f_mendez07.blogspot.com.petagram.R;

public class PerfilRecyclerViewFragment extends Fragment {
    private ArrayList<Mascotas> mascotasPerfil;
    private RecyclerView listaMascotasPerfil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reciclerview_perfil,container,false);

       listaMascotasPerfil = v.findViewById(R.id.rcvMascotasPerfil);

       GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
       gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
       listaMascotasPerfil.setLayoutManager(gridLayoutManager);
       inicializarLista();
       inicializarAdaptador();

       return v;

    }



    public void inicializarAdaptador(){
        MascotasPerfilFragment mascotasPerfilFragment = new MascotasPerfilFragment(mascotasPerfil, getActivity());
        listaMascotasPerfil.setAdapter(mascotasPerfilFragment);
    }

    public void inicializarLista(){
        mascotasPerfil = new ArrayList<>();
        mascotasPerfil.add(new Mascotas(R.drawable.leon,5));
        mascotasPerfil.add(new Mascotas(R.drawable.leon,3));
        mascotasPerfil.add(new Mascotas(R.drawable.leon,3));
        mascotasPerfil.add(new Mascotas(R.drawable.leon,2));
        mascotasPerfil.add(new Mascotas(R.drawable.leon,3));
        mascotasPerfil.add(new Mascotas(R.drawable.leon,1));
    }

}
