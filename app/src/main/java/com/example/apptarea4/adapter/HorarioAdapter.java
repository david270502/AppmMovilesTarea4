package com.example.apptarea4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptarea4.R;
import com.example.apptarea4.modelos.Horario;

import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder> {
    private List<Horario> horarios;

    public HorarioAdapter(List<Horario> horarios) {
        this.horarios = horarios;
    }

    @NonNull
    @Override
    public HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_horario, parent, false);
        return new HorarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioViewHolder holder, int position) {
        Horario horario = horarios.get(position);
        holder.textViewMateria.setText(horario.getNombreMateria());
        holder.textViewFecha.setText(horario.getFechaTarea());
        holder.textViewHora.setText(horario.getHoraTarea());
    }

    @Override
    public int getItemCount() {
        return horarios.size();
    }

    public class HorarioViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewMateria;
        public TextView textViewFecha;
        public TextView textViewHora;

        public HorarioViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMateria = itemView.findViewById(R.id.textViewMateria);
            textViewFecha = itemView.findViewById(R.id.textViewFecha);
            textViewHora = itemView.findViewById(R.id.textViewHora);
        }
    }

    public void actualizarLista(List<Horario> nuevaLista) {
        horarios.clear();
        horarios.addAll(nuevaLista);
        notifyDataSetChanged();
    }
}
