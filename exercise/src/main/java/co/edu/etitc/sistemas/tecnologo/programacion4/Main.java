package co.edu.etitc.sistemas.tecnologo.programacion4;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServicioBiblioteca servicio = new ServicioBiblioteca();


        servicio.agregarRecurso(new Libro(
                "Cien años de soledad", LocalDateTime.now(), true,
                "Gabriel García Márquez", "Editorial Sudamericana", 1967));

        servicio.agregarRecurso(new Libro(
                "1984", LocalDateTime.now(), false,
                "George Orwell", "Secker & Warburg", 1949));

        servicio.agregarRecurso(new Libro(
                "Orgullo y prejuicio", LocalDateTime.now(), true,
                "Jane Austen", "T. Egerton, Whitehall", 1813));

        servicio.agregarRecurso(new Periodico(
                "El Tiempo", LocalDateTime.now(), true,
                "Casa Editorial El Tiempo", LocalDateTime.now()));

        servicio.agregarRecurso(new Periodico(
                "El Espectador", LocalDateTime.now(), false,
                "Comunican S.A.", LocalDateTime.now()));

        servicio.agregarRecurso(new Periodico(
                "El Colombiano", LocalDateTime.now(), true,
                "El Colombiano S.A. & Cía. S.C.A.", LocalDateTime.now()));

        servicio.agregarRecurso(new Computador(
                "PC Gamer", LocalDateTime.now(), true,
                "Janus", TipoComputador.ESCRITORIO));

        servicio.agregarRecurso(new Computador(
                "Pavilion x360", LocalDateTime.now(), true,
                "Hewlett-Packard", TipoComputador.PORTATIL));

        servicio.agregarRecurso(new Computador(
                "PAD 7", LocalDateTime.now(), false,
                "Xiaomi", TipoComputador.TABLET));

        System.out.println("LISTA DE RECURSOS (INICIAL)\n");
        for (Recurso r : servicio.obtenerTodos()) {
            System.out.println(r); 
        }


        String criterioBusqueda = "Xiaomi";
        System.out.println("\nRECURSOS QUE COINCIDEN CON: \n" + criterioBusqueda + " ");
        List<Recurso> resultados = servicio.buscarRecursos(criterioBusqueda);
        for (Recurso r : resultados) {
            System.out.println(r);
        }

 
        if (!resultados.isEmpty()) {
            Recurso primero = resultados.get(0);
            servicio.eliminarRecurso(primero);
            System.out.println("\nSe ha eliminado el primer recurso que coincidía con el criterio.");
        }

        System.out.println("\n LISTA DE RECURSOS (ACTUALIZADA)\n");
        for (Recurso r : servicio.obtenerTodos()) {
            System.out.println(r);
        }
    }
}
