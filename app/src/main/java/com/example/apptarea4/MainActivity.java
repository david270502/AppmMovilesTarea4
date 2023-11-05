package com.example.apptarea4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apptarea4.modelos.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etUsu, etCon;
    private Button btnIngre;

    private ArrayList<Usuario> listaUsuario;
    private Usuario objUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ini();
    }
    public void ini()
    {
        etUsu = (EditText) findViewById(R.id.etUsu);
        etCon = (EditText) findViewById(R.id.etCon);
        btnIngre = (Button) findViewById(R.id.btnIngre);
        btnIngre.setOnClickListener(this);
    }

    private void llenarUsuarios()
    {
        listaUsuario = new ArrayList<Usuario>();
        listaUsuario.add(new Usuario("David","David@gmail.com","davidatencio"));
        listaUsuario.add(new Usuario("Julio","Julio@gmail.com","julioperez"));

    }

    private void ingresarSesion()
    {
        llenarUsuarios();
        String correo = etUsu.getText().toString();
        String contraseña = etCon.getText().toString();
        boolean usuarioEncontrado = false;
        for (int i=0; i<listaUsuario.size(); i++)
        {
            if (correo.equals(listaUsuario.get(i).getCorreo()) && contraseña.equals(listaUsuario.get(i).getContraseña()))
            {
                Toast.makeText(this , " Bienvenido " + listaUsuario.get(i).getNombre() , Toast.LENGTH_LONG).show();
                usuarioEncontrado = true;
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
            if (correo.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(this, "Llena los campos", Toast.LENGTH_LONG).show();
            } else {
                if (!usuarioEncontrado) {
                    Toast.makeText(this, "El correo o contraseña son incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnIngre)
        {
            ingresarSesion();
        }
    }
}