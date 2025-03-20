package co.edu.etitc.sistemas.tecnologo.programacion4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "co.edu.etitc.sistemas.tecnologo.programacion4")
@PropertySource("classpath:application.properties")
public class AppConfig {}
