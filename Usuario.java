package metodos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
@autor Maria Clara Santos Marca
@codido sis: 202302136
 * La clase Usuario representa un usuario en el sistema, incluyendo su nombre de
 * usuario, contraseña y su lista de tareas. Esta clase también permite guardar
 * y cargar usuarios desde un archivo de texto.
 */
public class Usuario {
    private String nombreUsuario;
    private String password;
    private String archivoUsuarios;
    private ListaDeTareas listaDeTareas;

    /**
     * Constructor de la clase Usuario. Inicializa el usuario con su nombre, contraseña y una lista de tareas vacía.
     * 
     * @param nombre      El nombre del usuario.
     * @param contraseña  La contraseña del usuario.
     */
    public Usuario(String nombre, String contraseña) {
        this.nombreUsuario = nombre;
        this.password = contraseña;
        this.archivoUsuarios = "usuarios.txt";
        this.listaDeTareas = new ListaDeTareas(nombre);
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombreUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return password;
    }

    /**
     * Obtiene la lista de tareas asociada con el usuario.
     * 
     * @return La lista de tareas del usuario.
     */
    public ListaDeTareas getListaDeTareas() {
        return listaDeTareas;
    }

    /**
     * Guarda la información del usuario (nombre y contraseña) en un archivo de
     * texto.
     */
    public void guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoUsuarios, true))) {
            bw.write(nombreUsuario + "," + password);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    /**
     * Carga la lista de usuarios desde el archivo "usuarios.txt". Si el archivo
     * no existe, se crea uno nuevo y devuelve una lista vacía.
     * 
     * @return Una lista de objetos Usuario cargados desde el archivo.
     */
    public static List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        File archivo = new File("usuarios.txt");
        
        // Si el archivo no existe, se crea uno vacío
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de usuarios: " + e.getMessage());
            }
            return usuarios;
        }

        // Leer el archivo línea por línea para cargar los usuarios
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    usuarios.add(new Usuario(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }

        return usuarios;
    }
}
