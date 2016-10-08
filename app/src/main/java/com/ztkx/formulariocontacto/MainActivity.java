package com.ztkx.formulariocontacto;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tiNombre;
    private TextInputEditText tiTelefono;
    private TextInputEditText tiFecha;
    private TextInputEditText tiEmail;
    private TextInputEditText tiDescripcion;
    private DatePicker datePicker;
    private int year;
    private int month;
    private int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiNombre        = (TextInputEditText) findViewById(R.id.tiNombre);
        tiTelefono      = (TextInputEditText) findViewById(R.id.tiTelefono);
        tiEmail         = (TextInputEditText) findViewById(R.id.tiEmail);
        tiDescripcion   = (TextInputEditText) findViewById(R.id.tiDescripcion);
        datePicker      = (DatePicker) findViewById(R.id.datePicker);


        Bundle params = getIntent().getExtras();

        if (params!=null){
            tiNombre.setText(params.getString("nombreContacto"));
            tiTelefono.setText(params.getString("telefonoContacto"));
            tiEmail.setText(params.getString("emailContacto"));
            tiDescripcion.setText(params.getString("descripcionContacto"));
            year            = params.getInt("yearFecha");
            month           = params.getInt("monthFecha");
            day             = params.getInt("dayFecha");
            datePicker.init(year,month,day,null);
        }

    }

    public void confirmarContacto(View v){

        if (tiNombre.getText().length()<1
                ||tiTelefono.getText().length()<1
                ||tiEmail.getText().length()<1
                ||tiDescripcion.getText().length()<1){
            Toast.makeText(this,R.string.error_datos,Toast.LENGTH_LONG).show();
        }
        else{
            getPickerDate();
            Intent intent = new Intent(MainActivity.this,Confirmacion.class);
            intent.putExtra("nombreContacto",tiNombre.getText().toString());
            intent.putExtra("yearFecha",year);
            intent.putExtra("monthFecha",month);
            intent.putExtra("dayFecha",day);
            intent.putExtra("telefonoContacto",tiTelefono.getText().toString());
            intent.putExtra("emailContacto",tiEmail.getText().toString());
            intent.putExtra("descripcionContacto",tiDescripcion.getText().toString());
            startActivity(intent);
            finish();
        }

    }

    public void getPickerDate (){
        year    = datePicker.getYear();
        month   = datePicker.getMonth();
        day     = datePicker.getDayOfMonth();
    }


}
