package co.edu.etitc.sistemas.tecnologo.programacion4;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            
            ServicioBiblioteca servicio = context.getBean(ServicioBiblioteca.class);

            System.out.println("Agregando recursos...");
            servicio.agregarLibro(new Libro(
                "Cien años de soledad", LocalDateTime.now(), true,
                "Gabriel García Márquez", "Editorial Sudamericana", 1967));

            servicio.agregarLibro(new Libro(
                "1984", LocalDateTime.now(), false,
                "George Orwell", "Secker & Warburg", 1949));

            servicio.agregarPeriodico(new Periodico(
                "El Tiempo", LocalDateTime.now(), true,
                "Casa Editorial El Tiempo", LocalDateTime.now()));

            servicio.agregarPeriodico(new Periodico(
                "El Espectador", LocalDateTime.now(), false,
                "Comunican S.A.", LocalDateTime.now()));

            servicio.agregarComputador(new Computador(
                "PC Gamer", LocalDateTime.now(), true,
                "Janus", TipoComputador.ESCRITORIO));

            servicio.agregarComputador(new Computador(
                "Pavilion x360", LocalDateTime.now(), true,
                "Hewlett-Packard", TipoComputador.PORTATIL));


            System.out.println("\n=== LISTA DE RECURSOS (INICIAL) ===");
            List<Recurso> recursosIniciales = servicio.obtenerTodos();
            for (Recurso recurso : recursosIniciales) {
                System.out.println(recurso);
            }


            String criterioBusqueda = "Pavilion";
            System.out.println("\n=== BUSCANDO RECURSOS CON CRITERIO: '" + criterioBusqueda + "' ===");
            List<Recurso> resultadosBusqueda = servicio.buscarRecursos(criterioBusqueda);
            for (Recurso recurso : resultadosBusqueda) {
                System.out.println(recurso);
            }

            if (!resultadosBusqueda.isEmpty()) {
                Recurso recursoAEliminar = resultadosBusqueda.get(0);
                System.out.println("\nEliminando recurso: " + recursoAEliminar.getTitulo());
                servicio.eliminarRecurso(recursoAEliminar);
            }

   
            System.out.println("\n=== LISTA DE RECURSOS (ACTUALIZADA) ===");
            List<Recurso> recursosActualizados = servicio.obtenerTodos();
            for (Recurso recurso : recursosActualizados) {
                System.out.println(recurso);
            }
        } //fin context
    }
}