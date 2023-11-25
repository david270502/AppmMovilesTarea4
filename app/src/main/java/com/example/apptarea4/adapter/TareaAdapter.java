package com.example.apptarea4.adapter;

// TareaAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptarea4.R;
import com.example.apptarea4.modelos.Tarea;

import java.util.List;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaViewHolder> {

    private List<Tarea> tareas;

    public TareaAdapter(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tarea, parent, false);
        return new TareaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {
        Tarea tarea = tareas.get(position);
        holder.textViewNombreTarea.setText(tarea.getNombre());
        holder.textViewFechaTarea.setText(tarea.getFecha());
        // Puedes agregar más campos aquí según tu modelo Tarea
    }


    @Override
    public int getItemCount() {
        return tareas.size();
    }

    public class TareaViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombreTarea;
        public TextView textViewFechaTarea;

        public TareaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombreTarea = itemView.findViewById(R.id.tNombre);
            textViewFechaTarea = itemView.findViewById(R.id.tFecha);
            // Corregido el orden de las referencias a las vistas
        }
    }

    public void actualizarLista(List<Tarea> nuevaLista) {
        tareas.clear();
        tareas.addAll(nuevaLista);
        notifyDataSetChanged();
    }
}

