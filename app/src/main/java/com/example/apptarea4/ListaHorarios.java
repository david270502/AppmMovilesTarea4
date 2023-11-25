package com.example.apptarea4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptarea4.adapter.HorarioAdapter;
import com.example.apptarea4.modelos.Horario;

import java.util.ArrayList;
import java.util.List;

public class ListaHorarios extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HorarioAdapter adapter;
    private List<Horario> horarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_horarios);

        recyclerView = findViewById(R.id.recycler_view_horarios);
        horarios = new ArrayList<>();
        adapter = new HorarioAdapter(horarios);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Obtener los datos del horario guardado desde el intent
        Intent intent = getIntent();
        if (intent != null) {
            String nombreMateria = intent.getStringExtra("nombreMateria");
            String fechaTarea = intent.getStringExtra("fechaTarea");
            String horaTarea = intent.getStringExtra("horaTarea");

            if (nombreMateria != null && fechaTarea != null && horaTarea != null) {
                // Crear un nuevo objeto Horario con los datos
                Horario nuevoHorario = new Horario(nombreMateria, fechaTarea, horaTarea);

                // Agregar el nuevo horario a la lista
                horarios.add(nuevoHorario);

                // Notificar al adaptador sobre el cambio en los datos
                adapter.notifyDataSetChanged();
            }
        }
    }
}
