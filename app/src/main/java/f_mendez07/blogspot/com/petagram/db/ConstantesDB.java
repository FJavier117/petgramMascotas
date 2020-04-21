package f_mendez07.blogspot.com.petagram.db;

public class ConstantesDB {
    // nombre y versión de la base de datos
    public static String DATABASE_NAME = "mascotas";
    public static int DATABASE_VERSION = 1;

    //nombre de la tabla
    public static String TABLE_PETS = "mascota";
    //identificador de la tabla
    public static String TABLE_PETS_ID = "id";
    //elementos de la tabla mascotas
    public static String TABLE_PETS_NAME = "nombre_mascota";
    public static String TABLE_PETS_FOTO = "foto_mascota";

    //nombre de la tabla
    public static String TABLE_LIKES_PETS = "mascota_likes";
    //identificador de la tabla
    public static String TABLE_LIKES_PETS_ID = "id";
    //alamacena el identificador de la mascota que recibio el like
    public static String TABLE_LIKES_PETS_ID_PET = "id_nombre_mascota";
    //alamacena el numero de likes
    public static String TABLE_LIKES_PETS_NUMERO_LIKES = "numero_likes";

}

