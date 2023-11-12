package com.example.apptarea4;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class RegistroTarea extends AppCompatActivity {

    private EditText editTextDate;
    private EditText editTextNombreTarea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tarea);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);

        editTextDate = findViewById(R.id.etFecha);
        editTextNombreTarea = findViewById(R.id.etTarea);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        Button btnGuardar = findViewById(R.id.btnguardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarTarea();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getTitle().toString()) {
            case "Inicio":
                startActivity(new Intent(RegistroTarea.this, MainActivity2.class));
                return true;
            case "Añadir":
                startActivity(new Intent(RegistroTarea.this, CrearHorario.class));
                return true;
            case "Salir":
                startActivity(new Intent(RegistroTarea.this, RegistroTarea.class));
                return true;
            case "Cerrar Sesion":
                startActivity(new Intent(RegistroTarea.this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year1, int month1, int day1) {
                String selectedDate = day1 + "/" + (month1 + 1) + "/" + year1;
                editTextDate.setText(selectedDate);
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    private void guardarTarea() {
        String nombreTarea = editTextNombreTarea.getText().toString();
        String fechaTarea = editTextDate.getText().toString();

        if (!nombreTarea.isEmpty() && !fechaTarea.isEmpty()) {
            mostrarMensaje("Tarea guardada: " + nombreTarea + " - Fecha: " + fechaTarea);
        } else {
            mostrarMensaje("Completa todos los campos");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
