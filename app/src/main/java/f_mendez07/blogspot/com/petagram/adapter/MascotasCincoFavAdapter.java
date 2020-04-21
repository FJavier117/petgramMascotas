package f_mendez07.blogspot.com.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.db.ConstructorDeMascotas;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;
import f_mendez07.blogspot.com.petagram.R;

public class MascotasCincoFavAdapter extends RecyclerView.Adapter<MascotasCincoFavAdapter.MascotasFavViewHolder> {
    private ArrayList<Mascotas> mascotasFav;
   private Activity activityFav;


    public MascotasCincoFavAdapter(ArrayList<Mascotas> mascotasFav,Activity activityFav) {
        this.mascotasFav = mascotasFav;
        this.activityFav = activityFav;
    }

    public static class MascotasFavViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCvFav;
        private TextView tvNombreCvFav;
        private TextView tvConteoCvFav;
        //private ImageButton imgbLikeCvFav;

        public MascotasFavViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCvFav = itemView.findViewById(R.id.imgCv);
            tvNombreCvFav = itemView.findViewById(R.id.tvNombreCv);
            tvConteoCvFav = itemView.findViewById(R.id.tvConteoCv);

        }
    }


    @NonNull
    @Override
    public MascotasFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotasFavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasFavViewHolder holder, int position) {
        holder.imgCvFav.setImageResource(mascotasFav.get(position).getImgFoto());
        holder.tvNombreCvFav.setText(mascotasFav.get(position).getNombreMascota());
        holder.tvConteoCvFav.setText(String.valueOf(mascotasFav.get(position).getLikes()));

        //ConstructorDeMascotas constructorDeMascotas = new ConstructorDeMascotas(activityFav);
        //holder.tvConteoCvFav.setText(String.valueOf(constructorDeMascotas.obternerLikesMascotas(mascotasFav.get(position))));
    }

    @Override
    public int getItemCount() {
        return mascotasFav.size();
    }


}