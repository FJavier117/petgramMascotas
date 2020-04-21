package f_mendez07.blogspot.com.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;

import f_mendez07.blogspot.com.petagram.ComparaLikesMascotas;
import f_mendez07.blogspot.com.petagram.db.BaseDeDatos;
import f_mendez07.blogspot.com.petagram.db.ConstructorDeMascotas;
import f_mendez07.blogspot.com.petagram.fragment.IMainRecyclerViewFragmentView;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

public class Presentador implements IPresentador  {
   private ConstructorDeMascotas mConstructorDeMascotas;
   private IMainRecyclerViewFragmentView mIMainRecyclerViewFragmentView;
   private Context mContext;
   private ArrayList<Mascotas> mMascotas;
   private ArrayList<Mascotas> mMascotasPopulares;

   public Presentador(IMainRecyclerViewFragmentView mIMainRecyclerViewFragmentView, Context mContext){
       this.mIMainRecyclerViewFragmentView = mIMainRecyclerViewFragmentView;
       this.mContext = mContext;
       obtenerMascotasDB();
   }

    @Override
    public void obtenerMascotasDB() {
       mConstructorDeMascotas = new ConstructorDeMascotas(mContext);
       mMascotas = mConstructorDeMascotas.obtenerMascotas();
       mostrarMascotasRVPrincipal();
    }

    @Override
    public void mostrarMascotasRVPrincipal() {
       mIMainRecyclerViewFragmentView.inicializarAdaptadorRV(mIMainRecyclerViewFragmentView.crearAdaptador(mMascotas));
       mIMainRecyclerViewFragmentView.generarLinearLayoutVertical();
    }









}
