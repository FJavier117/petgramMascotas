package f_mendez07.blogspot.com.petagram.presentador;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.pojo.Mascotas;


// EL OBJETIVO DEL PRESENTADOR ES SER INTERMEDIARIO ENTRE LA VISTA Y LA BASE DE DATOS
public interface IRecyclerViewFragmentPresenter {
    public void obtenerMascotasDB(); //obtenemos los contactos de la base de datos
    public void mostrarMascotasRVPrincipal(); //muestra los contactos ene un recycler view
    //public void mostrarMascotasFavoritas();


}
