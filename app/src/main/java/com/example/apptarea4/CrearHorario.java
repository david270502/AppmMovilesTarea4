package com.example.apptarea4;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class CrearHorario extends AppCompatActivity {

    private EditText editTextDate;
    private EditText editTextTime;
    private EditText editTextMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_horario);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);

        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextMateria = findViewById(R.id.editTextMateria);

        editTextDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        editTextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v);
            }
        });


        Button btnGuardar = findViewById(R.id.idCrear);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarHorario();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
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
    private void showTimePickerDialog(View v) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                editTextTime.setText(selectedTime);
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }


    private void guardarHorario() {
        String nombreMateria = editTextMateria.getText().toString();
        String horaTarea = editTextTime.getText().toString();
        String fechaTarea = editTextDate.getText().toString();

        if (!nombreMateria.isEmpty() && !fechaTarea.isEmpty()) {
            mostrarMensaje("Tarea guardada: " + nombreMateria + " - Fecha: " + fechaTarea + " - Hora:" + horaTarea);

            // Crear un intent para iniciar la actividad ListaHorariosActivity
            Intent intent = new Intent(this, ListaHorarios.class);

            // Pasar los datos de la tarea guardada al intent
            intent.putExtra("nombreMateria", nombreMateria);
            intent.putExtra("horaTarea", horaTarea);
            intent.putExtra("fechaTarea", fechaTarea);

            startActivity(intent);
        } else {
            mostrarMensaje("Completa todos los campos");
        }
    }


    private void mostrarMensaje(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}


