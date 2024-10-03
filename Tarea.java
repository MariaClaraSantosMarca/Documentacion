package metodos;

import java.time.LocalDate;

/**
@autor Maria Clara Santos Marca
@codido sis: 202302136
 * La clase Tarea representa una tarea individual con un nombre, una fecha de
 * vencimiento, una prioridad y un estado de completado.
 */
public class Tarea {
    private String nombreTarea;
    private LocalDate fechaTarea;
    private String prioridadTarea;
    private boolean estadoCompletada;

    /**
     * Constructor de la clase Tarea. Inicializa la tarea con su nombre, fecha y
     * prioridad, y establece el estado de completado como falso por defecto.
     * 
     * @param nombre    El nombre de la tarea.
     * @param fecha     La fecha de vencimiento de la tarea.
     * @param prioridad La prioridad de la tarea (puede ser alta, media o baja).
     */
    public Tarea(String nombre, LocalDate fecha, String prioridad) {
        this.nombreTarea = nombre;
        this.fechaTarea = fecha;
        this.prioridadTarea = prioridad;
        this.estadoCompletada = false;
    }

    /**
     * Obtiene el nombre de la tarea.
     * 
     * @return El nombre de la tarea.
     */
    public String getNombre() {
        return nombreTarea;
    }

    /**
     * Establece un nuevo nombre para la tarea.
     * 
     * @param nombre El nuevo nombre de la tarea.
     */
    public void setNombre(String nombre) {
        this.nombreTarea = nombre;
    }

    /**
     * Obtiene la fecha de vencimiento de la tarea.
     * 
     * @return La fecha de vencimiento de la tarea.
     */
    public LocalDate getFecha() {
        return fechaTarea;
    }

    /**
     * Establece una nueva fecha de vencimiento para la tarea.
     * 
     * @param fecha La nueva fecha de vencimiento.
     */
    public void setFecha(LocalDate fecha) {
        this.fechaTarea = fecha;
    }

    /**
     * Obtiene la prioridad de la tarea.
     * 
     * @return La prioridad de la tarea.
     */
    public String getPrioridad() {
        return prioridadTarea;
    }

    /**
     * Establece una nueva prioridad para la tarea.
     * 
     * @param prioridad La nueva prioridad de la tarea.
     */
    public void setPrioridad(String prioridad) {
        this.prioridadTarea = prioridad;
    }

    /**
     * Verifica si la tarea ha sido completada.
     * 
     * @return true si la tarea está completada, false de lo contrario.
     */
    public boolean isCompletada() {
        return estadoCompletada;
    }

    /**
     * Establece el estado de completado de la tarea.
     * 
     * @param completada true si la tarea está completada, false de lo contrario.
     */
    public void setCompletada(boolean completada) {
        this.estadoCompletada = completada;
    }

    /**
     * Devuelve una representación en cadena de la tarea, incluyendo su nombre,
     * fecha, prioridad y estado de completado.
     * 
     * @return Una cadena que representa la tarea.
     */
    @Override
    public String toString() {
        return "          # " + nombreTarea + "  " + "   [ FECHA: " + fechaTarea + " ]   " + "   [ PRIORIDAD "
                + prioridadTarea + "]   " + "   [ TAREA" + (estadoCompletada ? " COMPLETADA" : " NO COMPLETADA")
                + "]   ";
    }
}
