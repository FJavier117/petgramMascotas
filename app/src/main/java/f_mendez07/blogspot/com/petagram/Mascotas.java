package f_mendez07.blogspot.com.petagram;

public class Mascotas {
    private String nombreMascota;
    private int imgFoto;
    private  String conteoMascotaFavorita;

    //constructor de clase
    public Mascotas(int imgFoto, String nombreMascota,String conteoMascotaFavorita){
        this.imgFoto = imgFoto;
        this.nombreMascota =  nombreMascota;
        this.conteoMascotaFavorita = conteoMascotaFavorita;
    }

    public Mascotas(int imgFoto, String conteoMascotaFavorita){
        this.imgFoto = imgFoto;
        this.conteoMascotaFavorita = conteoMascotaFavorita;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(int imgFoto) {
        this.imgFoto = imgFoto;
    }

    public String getConteoMascotaFavorita() {
        return conteoMascotaFavorita;
    }

    public void setConteoMascotaFavorita(String conteoMascotaFavorita) {
        this.conteoMascotaFavorita = conteoMascotaFavorita;
    }
}
