package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.time.LocalDateTime;
import java.time.LocalDate;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        ServicioBiblioteca servicio = context.getBean(ServicioBiblioteca.class);

        System.out.println("--- Agregando recursos ---");
        
        // Libros
        servicio.agregar(new Libro("Cien años de soledad", LocalDateTime.now(), true, 
                                 "García Márquez", "Sudamericana", 1967));
        servicio.agregar(new Libro("El principito", LocalDateTime.now(), true, 
                                 "Antoine de Saint-Exupéry", "Salamandra", 1943));
        Libro libroInactivo = new Libro("1984", LocalDateTime.now(), false, 
                                      "George Orwell", "Debolsillo", 1949);
        servicio.agregar(libroInactivo);

        // Periódicos
        servicio.agregar(new Periodico("El Tiempo", LocalDateTime.now(), true, 
                                     LocalDate.now(), "Casa Editorial El Tiempo"));
        servicio.agregar(new Periodico("El Espectador", LocalDateTime.now(), true, 
                                     LocalDate.now().minusDays(1), "Compañía Periodística"));
        Periodico periodicoInactivo = new Periodico("La República", LocalDateTime.now(), false, 
                                                  LocalDate.now().minusDays(2), "Grupo La República");
        servicio.agregar(periodicoInactivo);

        // Computadores
        servicio.agregar(new Computador("HP Pavilion", LocalDateTime.now(), true, 
                                      "HP", "Pavilion x360", "Windows 11", TipoComputador.PORTATIL));
        servicio.agregar(new Computador("MacBook Pro", LocalDateTime.now(), true, 
                                      "Apple", "M2 Pro", "macOS", TipoComputador.PORTATIL));
        Computador computadorInactivo = new Computador("Dell Inspiron", LocalDateTime.now(), false, 
                                                     "Dell", "Inspiron 15", "Windows 10", TipoComputador.ESCRITORIO);
        servicio.agregar(computadorInactivo);

        System.out.println("\n--- Todos los recursos (activos e inactivos) ---");
        servicio.obtenerTodos().forEach(System.out::println);


        System.out.println("\n--- recursos inactivos ---");
        System.out.println("Quitando libro inactivo: " + libroInactivo.getNombre());
        servicio.quitarRecurso(libroInactivo);
        
        System.out.println("Quitando periódico inactivo: " + periodicoInactivo.getNombre());
        servicio.quitarRecurso(periodicoInactivo);
        
        System.out.println("Quitando computador inactivo: " + computadorInactivo.getNombre());
        servicio.quitarRecurso(computadorInactivo);


        System.out.println("\n--- Recursos totales ---");
        servicio.obtenerTodos().forEach(System.out::println);


        System.out.println("\n--- Buscando recursos con criterio 'Pro' ---");
        servicio.buscarRecursos("Pro").forEach(System.out::println);

        System.out.println("\n--- Buscando recursos con criterio 'años' ---");
        servicio.buscarRecursos("años").forEach(System.out::println);

        System.out.println("\n--- Buscando recursos con criterio 'HP' ---");
        servicio.buscarRecursos("HP").forEach(System.out::println);

        context.close();
    }
}