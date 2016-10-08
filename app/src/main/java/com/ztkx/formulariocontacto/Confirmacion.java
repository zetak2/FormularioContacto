package com.ztkx.formulariocontacto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    private TextView tvNombre,tvFecha,tvTelefono,tvEmail,tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle params = getIntent().getExtras();

        String nombre       = params.getString("nombreContacto");
        String fecha        = params.getString("fechaContacto");
        String telefono     = params.getString("telefonoContacto");
        String email        = params.getString("emailContacto");
        String descripcion  = params.getString("descripcionContacto");

        tvNombre        = (TextView) findViewById(R.id.tvNombreValor);
        tvFecha         = (TextView) findViewById(R.id.tvFechaValor);
        tvTelefono      = (TextView) findViewById(R.id.tvTelefonoValor);
        tvEmail         = (TextView) findViewById(R.id.tvEmailValor);
        tvDescripcion   = (TextView) findViewById(R.id.tvDescripcionValor);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
    }

    public void volver(View v){

        finish();
    }
}
