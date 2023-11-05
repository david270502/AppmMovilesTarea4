package com.example.apptarea4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class RegistroTarea extends AppCompatActivity {
    private EditText editTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tarea);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);
        editTextDate = findViewById(R.id.editTextDate);


        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((String) item.getTitle()) {
            case "Inicio":
                Intent inicio = new Intent(RegistroTarea.this, MainActivity2.class);
                startActivity(inicio);
                return true;
            case "Guardar":
                Intent guardar = new Intent(RegistroTarea.this, CrearHorario.class);
                startActivity(guardar);
                return true;
            case "Salir":
                Intent salir = new Intent(RegistroTarea.this, RegistroTarea.class);
                startActivity(salir);
                return true;
            case "Cerrar Sesion":
                Intent cerrar = new Intent(RegistroTarea.this, MainActivity.class);
                startActivity(cerrar);
                return true;
            default:
                return true;
        }
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
                String selectedDate = day + "/" + (month + 1) + "/" + year; // Formato de fecha deseado
                editTextDate.setText(selectedDate);
            }
        }, year, month, day);

        datePickerDialog.show();
    }
}
