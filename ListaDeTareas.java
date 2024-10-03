package metodos;

import java.time.LocalDate;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**

@autor Maria Clara Santos Marca
@codido sis: 202302136
 * La clase ListaDeTareas representa una lista de tareas personales para un
 * usuario en particular. Esta clase permite agregar, eliminar, cargar y
 * guardar tareas de un usuario a un archivo de texto. Cada tarea está asociada
 * a un nombre de usuario.
 */
public class ListaDeTareas {
    private String nombreDeUsuario;
    private List<Tarea> tareasPersonales;
    private String nombreArchivoTareas;

    /**
     * Constructor de la clase ListaDeTareas. Inicializa la lista de tareas y
     * carga las tareas desde el archivo correspondiente si existe.
     * 
     * @param nombreUsuario El nombre del usuario propietario de las tareas.
     */
    public ListaDeTareas(String nombreUsuario) {
        this.nombreDeUsuario = nombreUsuario;
        this.tareasPersonales = new ArrayList<>();
        this.nombreArchivoTareas = nombreUsuario + "_tareas.txt";
        cargarTareas();
    }

    /**
     * Agrega una nueva tarea a la lista de tareas del usuario y guarda las
     * tareas actualizadas en el archivo de texto.
     * 
     * @param tarea La tarea que se desea agregar.
     */
    public void agregarTarea(Tarea tarea) {
        tareasPersonales.add(tarea);
        guardarTareas();
    }

    /**
     * Elimina una tarea de la lista de tareas del usuario y guarda las tareas
     * actualizadas en el archivo de texto.
     * 
     * @param tarea La tarea que se desea eliminar.
     */
    public void eliminarTarea(Tarea tarea) {
        tareasPersonales.remove(tarea);
        guardarTareas();
    }

    /**
     * Obtiene la lista de todas las tareas personales del usuario.
     * 
     * @return La lista de tareas personales.
     */
    public List<Tarea> getTareas() {
        return tareasPersonales;
    }

    /**
     * Guarda la lista de tareas personales en un archivo de texto. Cada tarea
     * se guarda en una línea con su nombre, fecha, prioridad y estado de
     * completado.
     */
    public void guardarTareas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoTareas))) {
            for (Tarea tarea : tareasPersonales) {
                bw.write(tarea.getNombre() + "," + tarea.getFecha() + "," + tarea.getPrioridad() + ","
                        + tarea.isCompletada());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar tareas: " + e.getMessage());
        }
    }

    /**
     * Carga las tareas personales desde un archivo de texto, si el archivo existe.
     * Si no existe, no realiza ninguna acción. Cada línea en el archivo
     * representa una tarea con sus propiedades.
     */
    private void cargarTareas() {
        File archivo = new File(nombreArchivoTareas);
        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String nombre = partes[0];
                    LocalDate fecha = LocalDate.parse(partes[1]);
                    String prioridad = partes[2];
                    boolean completada = Boolean.parseBoolean(partes[3]);
                    Tarea tarea = new Tarea(nombre, fecha, prioridad);
                    tarea.setCompletada(completada);
                    tareasPersonales.add(tarea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar tareas: " + e.getMessage());
        }
    }
}
