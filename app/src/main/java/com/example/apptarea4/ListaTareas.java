package com.example.apptarea4;// ListaTareasActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptarea4.adapter.TareaAdapter;
import com.example.apptarea4.modelos.Tarea;

import java.util.ArrayList;
import java.util.List;

public class ListaTareas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TareaAdapter adapter;
    private MyApp myApp;
    private List<Tarea> tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas);

        // Obtener la instancia de MyApp
        myApp = (MyApp) getApplication();

        recyclerView = findViewById(R.id.recycler_view_tareas);
        tareas = myApp.getTareas();  // Obtener la lista de tareas de MyApp
        adapter = new TareaAdapter(tareas);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Obtener los datos de la tarea guardada desde el intent
        Intent intent = getIntent();
        if (intent != null) {
            String nombreTarea = intent.getStringExtra("nombreTarea");
            String fechaTarea = intent.getStringExtra("fechaTarea");
            if (nombreTarea != null && fechaTarea != null) {
                // Crear un nuevo objeto Tarea con los datos
                Tarea nuevaTarea = new Tarea(nombreTarea, fechaTarea);


                // Agregar la nueva tarea a la lista en MyApp
                myApp.agregarTarea(nuevaTarea);

                // Notificar al adaptador sobre el cambio en los datos
                //adapter.notifyDataSetChanged();
            }
        }
    }
}
