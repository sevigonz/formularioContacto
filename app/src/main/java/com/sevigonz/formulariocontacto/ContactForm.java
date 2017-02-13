package com.sevigonz.formulariocontacto;

import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.widget.DatePicker;

/**
 * Created by angel on 12/02/17.
 */

public class ContactForm {

    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String email;
    private String descripcion;
    private DatePicker datePicker;

    public ContactForm(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void getDatePicker(DatePicker f_c_fecha_nacimiento) {



        String[] parts = fechaNacimiento.split("/");
        Integer  day = Integer.valueOf(parts[0]); // 004
        Integer month = Integer.valueOf(parts[1]);
        Integer year = Integer.valueOf(parts[2]);
        // set current date into datepicker
        f_c_fecha_nacimiento.init(year, month, day, null);

    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
