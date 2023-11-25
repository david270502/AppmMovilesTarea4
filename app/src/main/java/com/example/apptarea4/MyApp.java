package com.example.apptarea4;

import android.app.Application;

import com.example.apptarea4.modelos.Tarea;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    private List<Tarea> tareas;
    public List<Tarea> getTareas() {
        if (tareas == null) {
            tareas = new ArrayList<>();
        }
        return tareas;
    }

    public void agregarTarea(Tarea tarea) {
        //Tareas().add((Tarea)//;
    }
}