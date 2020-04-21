package f_mendez07.blogspot.com.petagram.pojo;

public class Mascotas {
    private int id;
    private String nombreMascota;
    private int imgFoto;
    private int likes;

    public Mascotas() {

    }

    //constructor de clase
    public Mascotas(int imgFoto, String nombreMascota,int likes){
        this.imgFoto = imgFoto;
        this.nombreMascota =  nombreMascota;
        this.likes= likes;
    }

    public Mascotas(int imgFoto, int likes){
        this.imgFoto = imgFoto;
        this.likes = likes;
    }


    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(int imgFoto) {
        this.imgFoto = imgFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
