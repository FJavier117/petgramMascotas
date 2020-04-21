package f_mendez07.blogspot.com.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import f_mendez07.blogspot.com.petagram.R;
import f_mendez07.blogspot.com.petagram.pojo.Mascotas;

public class MascotasPerfilFragment extends RecyclerView.Adapter<MascotasPerfilFragment.MascotasPerfilViewHolder> {
    private ArrayList<Mascotas> mascotasPerfil;
    private Activity activityPerfil;

    public MascotasPerfilFragment(ArrayList<Mascotas> mascotasPerfil, Activity activityPerfil) {
        this.mascotasPerfil = mascotasPerfil;
        this.activityPerfil = activityPerfil;
    }

    public static class MascotasPerfilViewHolder extends RecyclerView.ViewHolder{
        ImageView imgCvPerfil;
        TextView tvCvConteoPerfil;

        public MascotasPerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCvPerfil = itemView.findViewById(R.id.imgCvPerfil);
            tvCvConteoPerfil = itemView.findViewById(R.id.tvConteoCvPerfil);
        }
    }


    @NonNull
    @Override
    public MascotasPerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas_perfil,parent,false);
        return new MascotasPerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasPerfilViewHolder holder, int position) {
        holder.imgCvPerfil.setImageResource(mascotasPerfil.get(position).getImgFoto());
        holder.tvCvConteoPerfil.setText(String.valueOf(mascotasPerfil.get(position).getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotasPerfil.size();
    }


}