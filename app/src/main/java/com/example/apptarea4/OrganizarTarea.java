package com.example.apptarea4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;

public class OrganizarTarea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizar_tarea);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((String) item.getTitle()) {
            case "Inicio":  Intent inicio = new Intent(OrganizarTarea.this, MainActivity2.class);
                startActivity(inicio);
                return true;
            case "Guardar" : Intent guardar = new Intent(OrganizarTarea.this, CrearHorario.class);
                startActivity(guardar);
                return true;
            case "Salir" : Intent salir = new Intent(OrganizarTarea.this, RegistroTarea.class);
                startActivity(salir);
                return true;
            case "Cerrar Sesion" : Intent cerrar = new Intent(OrganizarTarea.this, MainActivity.class);
                startActivity(cerrar);
                return true;
            default:
                return true;
        }

    }
}
