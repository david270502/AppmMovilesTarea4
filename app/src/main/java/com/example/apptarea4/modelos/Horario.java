package com.example.apptarea4.modelos;

    public class Horario {
        private String nombreMateria;
        private String fechaTarea;
        private String horaTarea;

        // Constructor
        public Horario(String nombreMateria, String fechaTarea, String horaTarea) {
            this.nombreMateria = nombreMateria;
            this.fechaTarea = fechaTarea;
            this.horaTarea = horaTarea;
        }

        // Getters y setters según sea necesario
        public String getNombreMateria() {
            return nombreMateria;
        }

        public String getFechaTarea() {
            return fechaTarea;
        }

        public String getHoraTarea() {
            return horaTarea;
        }
    }


