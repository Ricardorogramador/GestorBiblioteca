# Gestor de Biblioteca Digital

## Descripción

El Gestor de Biblioteca Digital es un proyecto Java enfocado en la gestión de materiales bibliográficos (libros y revistas), usuarios y préstamos, utilizando archivos de texto para la persistencia de datos. El sistema está diseñado para demostrar habilidades de Java intermedio, como Programación Orientada a Objetos (POO), uso de interfaces y clases abstractas, manejo de ArrayList, condicionales, manejo de excepciones, y persistencia de datos. Es una solución ideal para quienes buscan consolidar estos conocimientos en un solo proyecto, útil tanto para uso académico como profesional.

## Características

- **Registro y gestión de libros y revistas**, con atributos específicos para cada tipo.
- **Gestión de usuarios** y seguimiento de sus préstamos.
- **Realización de préstamos**, vinculando usuarios y materiales.
- **Persistencia de datos en archivos .txt**, permitiendo guardar y recuperar la información.
- **Uso de ArrayList** para la administración de colecciones de objetos.
- **Manejo de excepciones** para garantizar la integridad en operaciones de lectura/escritura.
- **POO avanzada**: clases abstractas, interfaces, polimorfismo y el operador `instanceof`.
- **Menú interactivo** por consola para facilitar la gestión.

## Estructura del proyecto

- `MaterialBiblioteca` (abstracta): Clase base para libros y revistas.
- `Libro`: Extiende MaterialBiblioteca, agrega autor y número de páginas.
- `Revista`: Extiende MaterialBiblioteca, agrega número de edición y periodicidad.
- `Usuario`: Representa a los usuarios y sus préstamos.
- `Prestamo`: Relaciona usuario y material, incluye fechas.
- `IPersistencia`: Interfaz para guardar/cargar datos.
- `PersistenciaTXT`: Implementa IPersistencia usando archivos .txt.
- `Biblioteca`: Clase principal para la lógica y el menú.

## Instalación y ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Ricardorogramador/gestor-biblioteca-digital.git
   ```
2. Compila los archivos Java:
   ```bash
   javac *.java
   ```
3. Ejecuta la aplicación:
   ```bash
   java Biblioteca
   ```

## Uso

El sistema presenta un menú por consola para:
- Registrar materiales y usuarios.
- Realizar préstamos y devoluciones.
- Listar materiales y usuarios.
- Guardar y cargar la información desde archivos .txt.

## Requisitos

- Java SE 8 o superior.
- Permisos de escritura/lectura en el directorio del proyecto.

---

¡Explora, aprende y amplía tus habilidades en Java intermedio con el Gestor de Biblioteca Digital!
