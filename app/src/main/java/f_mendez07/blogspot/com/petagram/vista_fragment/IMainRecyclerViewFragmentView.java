package f_mendez07.blogspot.com.petagram.vista_fragment;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.adapter.MascotasAdapter;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

//mi view model de como funciona mi MainRecyclerViewFragment

public interface IMainRecyclerViewFragmentView {
    public void generarLinearLayoutVertical(); //presentamos los datos de forma lineal
    public MascotasAdapter crearAdaptador(ArrayList<Mascotas> mascotas); //Retorna un adaptador de Mascotas recibiendo la lista de contactos
    public void inicializarAdaptadorRV(MascotasAdapter adapter); // Recibe el adaptador

}
