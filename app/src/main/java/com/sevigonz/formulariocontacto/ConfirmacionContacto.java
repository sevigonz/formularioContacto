package com.sevigonz.formulariocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ConfirmacionContacto extends AppCompatActivity {


    ContactForm contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirmacion_contacto);

        Bundle parametros = getIntent().getExtras();

        String nombre_completo = parametros.getString(getResources().getString(R.string.nombre_completo));
        String fecha_nacimiento = parametros.getString(getResources().getString(R.string.fecha_nacimiento));
        String telefono = parametros.getString(getResources().getString(R.string.telefono));
        String email = parametros.getString(getResources().getString(R.string.email));
        String descripcion_contacto = parametros.getString(getResources().getString(R.string.descripcion_contacto));


        contacto = new ContactForm(nombre_completo, telefono, email);
        contacto.setDescripcion(descripcion_contacto);
        contacto.setFechaNacimiento(fecha_nacimiento);

        TextView cc_nombre_completo = (TextView) findViewById(R.id.cc_nombre_completo);
        TextView cc_fecha_nacimiento = (TextView) findViewById(R.id.cc_fecha_nacimiento);
        TextView cc_telefono = (TextView) findViewById(R.id.cc_telefono);
        TextView cc_email = (TextView) findViewById(R.id.cc_email);
        TextView cc_descripcion_contacto = (TextView) findViewById(R.id.cc_descripcion_contacto);


        cc_nombre_completo.setText(contacto.getNombre());
        cc_fecha_nacimiento.setText(contacto.getFechaNacimiento());
        cc_telefono.setText(contacto.getTelefono());
        cc_email.setText(contacto.getEmail());
        cc_descripcion_contacto.setText(contacto.getDescripcion());


        addButtonSiguiente();

    }




    public void addButtonSiguiente() {

        Button editarContacto = (Button) findViewById(R.id.editar_contacto);



        editarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ConfirmacionContacto.this, MainActivity.class);

                intent.putExtra(getResources().getString(R.string.nombre_completo), (String)((TextView) findViewById(R.id.cc_nombre_completo)).getText().toString());
                intent.putExtra(getResources().getString(R.string.fecha_nacimiento), (String)((TextView) findViewById(R.id.cc_fecha_nacimiento)).getText().toString());
                intent.putExtra(getResources().getString(R.string.telefono),(String)((TextView) findViewById(R.id.cc_telefono)).getText().toString());
                intent.putExtra(getResources().getString(R.string.email), (String)((TextView) findViewById(R.id.cc_email)).getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion_contacto), (String)((TextView) findViewById(R.id.cc_descripcion_contacto)).getText().toString());

                startActivity(intent);
            };
        });

    }

}
