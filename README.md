##ESTRUCTURA ORGANIZACIONAL
exercise/src/main/java/co/edu/etitc/sistemas/tecnologo/programacion4/
│-- Main.java

│-- ServicioBiblioteca.java

│-- Recurso.java (Clase abstracta)

│-- Libro.java (Extiende Recurso)

│-- Periodico.java (Extiende Recurso)

│-- Computador.java (Extiende Recurso)

│-- TipoComputador.java (Enum para definir tipos de computadora)

## Requisitos

- JDK 17 o superior  
- Apache Maven 

##Descripción de Archivos:

Main.java: Es el punto de entrada del programa. Aquí se crean instancias de los recursos y se prueban las funciones de la biblioteca.

ServicioBiblioteca.java: Clase que gestiona los recursos en la biblioteca (agregar, eliminar, buscar y listar).

Recurso.java: Clase abstracta que define las características generales de un recurso.

Libro.java: Representa libros con atributos adicionales como autor, editorial y año de publicación.

Periodico.java: Representa periódicos con fecha de publicación y editorial.

Computador.java: Representa computadoras con atributos como marca, modelo y sistema operativo.

TipoComputador.java: Enum para clasificar los tipos de computadoras (PORTÁTIL, ESCRITORIO, TABLET).


##El programa realiza las siguientes acciones:

Crea una instancia de ServicioBiblioteca.
Agrega 3 libros, 3 periódicos y 3 computadores.
Muestra la lista de recursos en la biblioteca.
Realiza una búsqueda por criterio.
Elimina el primer recurso que coincide con el criterio.
Muestra la lista actualizada después de la eliminación.

## Cómo Ejecutarlo

1. git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio

##compilar maven en Visual Studio Code: 
mvn clean compile
& "$env:JAVA_HOME\bin\java.exe" -jar exercise-1.0.1-SNAPSHOT.jar
