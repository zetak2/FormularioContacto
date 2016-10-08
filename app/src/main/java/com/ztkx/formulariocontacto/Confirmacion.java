package com.ztkx.formulariocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    private TextView tvNombre,tvFecha,tvTelefono,tvEmail,tvDescripcion;
    String nombre;
    String telefono;
    String email;
    String descripcion;
    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle params = getIntent().getExtras();

        nombre       = params.getString("nombreContacto");
        telefono     = params.getString("telefonoContacto");
        email        = params.getString("emailContacto");
        descripcion  = params.getString("descripcionContacto");
        year            = params.getInt("yearFecha");
        month           = params.getInt("monthFecha");
        day             = params.getInt("dayFecha");

        tvNombre        = (TextView) findViewById(R.id.tvNombreValor);
        tvFecha         = (TextView) findViewById(R.id.tvFechaValor);
        tvTelefono      = (TextView) findViewById(R.id.tvTelefonoValor);
        tvEmail         = (TextView) findViewById(R.id.tvEmailValor);
        tvDescripcion   = (TextView) findViewById(R.id.tvDescripcionValor);

        tvNombre.setText(nombre);
        tvFecha.setText(stringFecha());
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
    }

    public void volver(View v){
        Intent intentEditar = new Intent(Confirmacion.this,MainActivity.class);
        intentEditar.putExtra("nombreContacto",nombre);
        intentEditar.putExtra("yearFecha",year);
        intentEditar.putExtra("monthFecha",month);
        intentEditar.putExtra("dayFecha",day);
        intentEditar.putExtra("telefonoContacto",telefono);
        intentEditar.putExtra("emailContacto",email);
        intentEditar.putExtra("descripcionContacto",descripcion);
        startActivity(intentEditar);
        finish();
    }

    public String stringFecha(){
        String stringFecha= day+" / "+(month+1)+" / "+year;
        return stringFecha;
    }
}
