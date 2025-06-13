package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(Main.class, args)) {

            System.out.println("Aplicación de Biblioteca Digital iniciada correctamente");
            System.out.println("Accede a la interfaz web en: http://localhost:8080/static/index.html");
            
            // aplicación corriendo
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }
}