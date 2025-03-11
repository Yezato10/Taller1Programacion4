package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class AppInfo {

    @Value("${app.name}") 
    private String nombreApp;

    @PostConstruct 
    public void imprimirNombreApp() {
        System.out.println("\n=== APLICACIÓN INICIADA ===");
        System.out.println("Nombre: " + nombreApp);
        System.out.println("===========================\n");
    }
}