## Lista de Tareas 

Este proyecto consiste en una aplicación de escritorio desarrollada en Java que permite a los usuarios gestionar sus tareas de manera eficiente.
A través de una interfaz gráfica de usuario basada en Swing, los usuarios pueden registrar y autenticar sus cuentas, y acceder a funcionalidades avanzadas para la administración de tareas, tales como agregar, modificar, eliminar, marcar como completadas, y exportar la lista de tareas.

### Descripción General

La aplicación está diseñada para proporcionar a los usuarios una experiencia intuitiva en la gestión de tareas personales. Cada usuario tiene acceso a su propia lista de tareas, la cual puede ser personalizada con prioridades, fechas de vencimiento y estados de completado.
Además, la aplicación permite la persistencia de datos, de manera que las tareas se almacenan y recuperan desde archivos locales para cada usuario registrado.

### Características Principales

1. **Gestión de Usuarios**:
   - **Registro**: Los usuarios pueden crear cuentas con un nombre de usuario y una contraseña.
   - **Inicio de sesión**: Los usuarios autenticados pueden acceder a su lista de tareas personal.
  
2. **Gestión de Tareas**:
   - **Agregar Tareas**: Los usuarios pueden agregar tareas nuevas, especificando el nombre, la fecha de vencimiento y la prioridad (Alta, Media o Baja).
   - **Modificar Tareas**: Es posible editar las propiedades de las tareas existentes.
   - **Marcar como Completada**: Los usuarios pueden marcar las tareas como completadas para llevar un registro de su progreso.
   - **Eliminar Tareas**: Las tareas completadas o no deseadas pueden ser eliminadas de la lista.
  
3. **Exportar Lista de Tareas**: La lista de tareas se puede exportar a un archivo de texto para su impresión o respaldo.
  
4. **Interfaz Gráfica Avanzada**:
   - La aplicación utiliza componentes Swing para una interfaz de usuario amigable y moderna.
   - Se han aplicado colores elegantes y configuraciones visuales para mejorar la experiencia de usuario.

### Tecnologías Utilizadas

El desarrollo de esta aplicación se basa en las siguientes tecnologías:

- **Java**: Lenguaje de programación principal utilizado para la lógica de la aplicación y la GUI.
- **Swing**: Biblioteca de Java para la creación de interfaces gráficas, que permite la creación de una GUI robusta y personalizable.
- **Manejo de Archivos (File I/O)**: Se emplean operaciones de entrada y salida de archivos para el almacenamiento persistente de los datos de usuarios y tareas.

### Estructura del Proyecto

El proyecto sigue una estructura modular basada en clases que facilitan la mantenibilidad y la escalabilidad del código. A continuación, se describen las principales clases del proyecto:

### `InterfazGrafica.java`

- **Descripción**: Esta clase es responsable de la gestión de la interfaz gráfica de usuario (GUI) y de coordinar las interacciones del usuario con el sistema.
- **Principales Responsabilidades**:
  - Gestionar el registro e inicio de sesión de usuarios.
  - Mostrar la lista de tareas personalizadas de cada usuario.
  - Proveer botones y acciones para agregar, modificar, completar y eliminar tareas.
  - Implementar la funcionalidad para imprimir y exportar la lista de tareas a un archivo.
  
- **Métodos Principales**:
  - `iniciarSesion()`: Permite a los usuarios autenticarse.
  - `registrarUsuario()`: Permite la creación de nuevas cuentas de usuario.
  - `mostrarListaDeTareas()`: Muestra las tareas del usuario autenticado.
  - `añadirTarea()`, `modificarTarea()`, `completarTarea()`, `eliminarTarea()`: Gestiona las operaciones CRUD de las tareas.
  - `imprimirLista()`: Exporta la lista de tareas a un archivo de texto para su impresión.

### `ListaDeTareas.java`

- **Descripción**: Esta clase gestiona el conjunto de tareas asociadas a cada usuario, proporcionando métodos para agregar, eliminar y almacenar tareas.
- **Principales Responsabilidades**:
  - Manejar la adición, modificación y eliminación de tareas.
  - Guardar las tareas en archivos locales para la persistencia de datos.
  - Cargar las tareas desde los archivos cuando el usuario inicia sesión.

- **Métodos Principales**:
  - `agregarTarea(Tarea tarea)`: Añade una nueva tarea a la lista.
  - `eliminarTarea(Tarea tarea)`: Elimina una tarea específica de la lista.
  - `guardarTareas()`: Guarda la lista de tareas en un archivo local.
  - `cargarTareas()`: Carga las tareas desde un archivo específico para el usuario actual.

### `Tarea.java`

- **Descripción**: La clase `Tarea` representa una unidad de trabajo que el usuario necesita completar. Incluye propiedades como nombre de tarea, fecha de vencimiento, prioridad y estado de completado.
- **Principales Responsabilidades**:
  - Almacenar y gestionar la información relacionada con una tarea individual.
  
- **Atributos**:
  - `nombreTarea`: El nombre o título de la tarea.
  - `fechaTarea`: Fecha de vencimiento de la tarea.
  - `prioridadTarea`: Indica la prioridad (Alta, Media, Baja).
  - `estadoCompletada`: Booleano que indica si la tarea ha sido completada.

### `Usuario.java`

- **Descripción**: La clase `Usuario` maneja la información relacionada con cada usuario, incluyendo las credenciales de inicio de sesión y la lista de tareas asociadas.
- **Principales Responsabilidades**:
  - Almacenar los datos del usuario (nombre, contraseña, lista de tareas).
  - Guardar y cargar los usuarios desde el archivo `usuarios.txt`.

- **Métodos Principales**:
  - `cargarUsuarios()`: Carga la lista de usuarios desde un archivo para validar el inicio de sesión.
  - `guardarUsuarios()`: Guarda los datos de los usuarios registrados en el sistema.

### `Main.java`

- **Descripción**: Esta clase contiene el punto de entrada principal del programa, inicializando la interfaz gráfica y dando inicio a la aplicación.
- **Método**: 
  - `main(String[] args)`: Inicializa la aplicación creando una instancia de `InterfazGrafica` y mostrando la pantalla de inicio de sesión.

## Persitencia de Datos

### Usuarios

Los datos de los usuarios registrados en el sistema se almacenan en un archivo llamado `usuarios.txt`. Este archivo es leído cada vez que la aplicación se inicia para cargar los usuarios existentes y verificar las credenciales durante el inicio de sesión.

### Tareas

Cada usuario tiene un archivo de tareas asociado, cuyo nombre sigue el formato `<nombreUsuario>_tareas.txt`. En este archivo se almacenan las tareas creadas por el usuario, y el contenido del archivo se carga automáticamente cuando el usuario inicia sesión.

## Instrucciones de Instalación y Ejecución

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/username/repository.git
     ```
2.**Abrir el proyecto**: Utiliza tu entorno aplicacion de trabajo favorito (Eclipse, IntelliJ IDEA, Visual Studio Code, etc.) para abrir el proyecto clonado.
Instalar el JDK: Asegúrate de que el JDK (Java Development Kit) esté instalado en tu sistema.
3.**Ejecutar la aplicación**: Ejecuta la clase Main.java para iniciar la aplicación. La ventana de inicio de sesión se abrirá automáticamente.
4.**Uso de la interfaz gráfica**: Una vez iniciada la aplicación, utiliza la GUIA para registrar nuevos usuarios, iniciar sesión y gestionar las tareas según tus preferencias.
###Futuras Mejoras

**Seguridad Mejorada**: Implementar un mecanismo de encriptación de contraseñas para mejorar la seguridad en el almacenamiento de datos sensibles.

**Clasificación de Tareas**: Agregar la capacidad de clasificar las tareas por prioridad, fecha de vencimiento o estado de completado.

**Etiquetas y Categorías**: Permitir a los usuarios clasificar las tareas en categorías o asignarles etiquetas para una organización más eficiente.

**Integración con Base de Datos**: Migrar el almacenamiento de datos a una base de datos relacional para mayor escalabilidad y robustez.
Autor

Este proyecto fue desarrollado por Maria Clara Santos Marca como parte de un esfuerzo académico y personal para aprender y aplicar conceptos avanzados de programación en Java.
