package f_mendez07.blogspot.com.petagram.fragment;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.adapter.MascotasAdapter;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

public interface IMainRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public MascotasAdapter crearAdaptador(ArrayList<Mascotas> mascotas);
    public void inicializarAdaptadorRV(MascotasAdapter adapter);

}
