package f_mendez07.blogspot.com.petagram.menu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import f_mendez07.blogspot.com.petagram.smtp.GMailSender;
import f_mendez07.blogspot.com.petagram.R;

public class MenuContacto extends AppCompatActivity {

    private static final int MY_PERMISSIONS_INTERNET =0;
    private EditText edtNombre;
    private EditText edtCorreo;
    private EditText edtMensaje;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_contacto);
        edtNombre = findViewById(R.id.edtNombre);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtMensaje = findViewById(R.id.edtMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);



        Toolbar toolbar = findViewById(R.id.miToolBarMenuContacto);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarSMS();
                Toast.makeText(getApplicationContext(),"Comentario enviado",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void permisos(){

    }

    public void enviarSMS(){

        final String nombre = edtNombre.getText().toString().trim();
        final String correo = edtCorreo.getText().toString().trim();
        final String mensaje = edtMensaje.getText().toString().trim();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //es necesario logear el correo que recibira los mensajes
                    GMailSender sender = new GMailSender("aquiva el correo@gmail.com",
                            "contraseña");
                    sender.senMail(nombre, mensaje,
                            correo, "correo que recibe los mensajes@gmail.com");
                } catch (Exception e) {
                    Log.e("Correo enviado", e.getMessage(), e);
                }
            }

        }).start();
    }
}
