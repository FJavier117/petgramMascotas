package f_mendez07.blogspot.com.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.db.ConstructorDeMascotas;
import f_mendez07.blogspot.com.petagram.vista_fragment.IMainRecyclerViewFragmentView;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

//presentador correspondiente a la clase MainRecyclerViewFragment
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
   private ConstructorDeMascotas mConstructorDeMascotas;
   private IMainRecyclerViewFragmentView mIMainRecyclerViewFragmentView;
   private Context mContext;
   private ArrayList<Mascotas> mMascotas;

   public RecyclerViewFragmentPresenter(IMainRecyclerViewFragmentView mIMainRecyclerViewFragmentView, Context mContext){
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
