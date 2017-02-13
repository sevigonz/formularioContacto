package com.sevigonz.formulariocontacto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {


    ContactForm contactForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButtonSiguiente();

        Bundle parametros = getIntent().getExtras();

        if(parametros != null){

            String nombre_completo = parametros.getString(getResources().getString(R.string.nombre_completo));
            String fecha_nacimiento = parametros.getString(getResources().getString(R.string.fecha_nacimiento));
            String telefono = parametros.getString(getResources().getString(R.string.telefono));
            String email = parametros.getString(getResources().getString(R.string.email));
            String descripcion_contacto = parametros.getString(getResources().getString(R.string.descripcion_contacto));


            contactForm = new ContactForm(nombre_completo, telefono, email);
            contactForm.setDescripcion(descripcion_contacto);
            contactForm.setFechaNacimiento(fecha_nacimiento);

            TextView f_c_nombre_completo = (TextView) findViewById(R.id.f_c_nombre_completo);
            DatePicker f_c_fecha_nacimiento = (DatePicker) findViewById(R.id.f_c_fecha_nacimiento);
            TextView f_c_telefono = (TextView) findViewById(R.id.f_c_telefono);
            TextView f_c_email = (TextView) findViewById(R.id.f_c_email);
            TextView f_c_descripcion_contacto = (TextView) findViewById(R.id.f_c_descripcion_contacto);


            f_c_nombre_completo.setText(contactForm.getNombre());
             contactForm.getDatePicker(f_c_fecha_nacimiento);
            f_c_telefono.setText(contactForm.getTelefono());
            f_c_email.setText(contactForm.getEmail());
            f_c_descripcion_contacto.setText(contactForm.getDescripcion());
        }

    }


    public void addButtonSiguiente() {

        Button buttonSiguiente = (Button) findViewById(R.id.f_c_enviar_contacto);



        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ConfirmacionContacto.class);


                intent.putExtra(getResources().getString(R.string.nombre_completo), (String)((EditText) findViewById(R.id.f_c_nombre_completo)).getText().toString());

                DatePicker datePicker = (DatePicker) findViewById(R.id.f_c_fecha_nacimiento);
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year =  datePicker.getYear();

                intent.putExtra(getResources().getString(R.string.fecha_nacimiento),  day + "/" + month + "/" + year);
                intent.putExtra(getResources().getString(R.string.telefono), (String)((EditText) findViewById(R.id.f_c_telefono)).getText().toString());
                intent.putExtra(getResources().getString(R.string.email), (String)((EditText) findViewById(R.id.f_c_email)).getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion_contacto), (String)((EditText) findViewById(R.id.f_c_descripcion_contacto)).getText().toString());

                startActivity(intent);
            };
        });

    }


}
