package com.example.apptarea4;

import android.os.Bundle;
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

        // Verificar si hay datos extras en el intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Obtener los datos de la tarea guardada
            String nombreMateria = extras.getString("nombreMateria");
            String fechaTarea = extras.getString("fechaTarea");
            String horaTarea = extras.getString("horaTarea");

            // Crear un nuevo objeto Horario con los datos
            Horario nuevoHorario = new Horario(nombreMateria, fechaTarea, horaTarea);

            // Agregar el nuevo horario a la lista
            horarios.add(nuevoHorario);

            // Notificar al adaptador sobre el cambio en los datos
            adapter.notifyDataSetChanged();
        }
    }
}
