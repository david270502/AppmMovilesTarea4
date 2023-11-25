package com.example.apptarea4;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.apptarea4.modelos.Tarea;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RegistroTarea extends AppCompatActivity {

    private EditText editTextDate;
    private EditText editTextNombreTarea;

    // Lista de tareas
    private List<Tarea> tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tarea);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);

        editTextDate = findViewById(R.id.etFecha);
        editTextNombreTarea = findViewById(R.id.etTarea);

        // Inicializar la lista de tareas
        tareas = new ArrayList<>();

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
            // Crear una nueva tarea
            MyApp myApp = (MyApp) getApplication();
            myApp.getTareas().add(new Tarea(nombreTarea, fechaTarea));

            Intent intent = new Intent(this, ListaTareas.class);
            intent.putExtra("nombreTarea", nombreTarea);
            intent.putExtra("fechaTarea", fechaTarea);
            startActivity(intent);

            // Notificar al adaptador sobre el cambio en los datos (si estás utilizando un RecyclerView)
            // adapter.notifyDataSetChanged();

            // Mostrar mensaje de éxito
            mostrarMensaje("Tarea guardada: " + nombreTarea + " - Fecha: " + fechaTarea);
        } else {
            // Mostrar mensaje de error si no se completan todos los campos
            mostrarMensaje("Completa todos los campos");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
