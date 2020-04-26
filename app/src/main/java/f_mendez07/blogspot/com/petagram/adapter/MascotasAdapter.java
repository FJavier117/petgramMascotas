package f_mendez07.blogspot.com.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.db.ConstructorDeMascotas;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;
import f_mendez07.blogspot.com.petagram.R;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotasViewHolder>{
   private ArrayList<Mascotas> mascotas;
   private Activity activity;

    public MascotasAdapter(ArrayList<Mascotas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotasViewHolder mascotasViewHolder, final int position) {
        mascotasViewHolder.imgCv.setImageResource(mascotas.get(position).getImgFoto());
        mascotasViewHolder.tvNombreCv.setText(mascotas.get(position).getNombreMascota());
        mascotasViewHolder.tvConteoCv.setText(String.valueOf(mascotas.get(position).getLikes())+ " Likes");

        mascotasViewHolder.imgbLikeCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConstructorDeMascotas constructorDeMascotas = new ConstructorDeMascotas(activity);
                //damos like a la mascota y obtenemos la posición
                constructorDeMascotas.darLikesMascotas(mascotas.get(position));
                //mostramos en el textview el numero de likes
                mascotasViewHolder.tvConteoCv.setText(String.valueOf(constructorDeMascotas.obternerLikesMascotas(mascotas.get(position))));
            }
        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCv;
        private TextView tvNombreCv;
        private TextView tvConteoCv;
        private ImageButton imgbLikeCv;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCv = itemView.findViewById(R.id.imgCv);
            tvNombreCv =itemView.findViewById(R.id.tvNombreCv);
            tvConteoCv = itemView.findViewById(R.id.tvConteoCv);
            imgbLikeCv = itemView.findViewById(R.id.imgbLikeCv);
        }
    }
}