# GRUPO DE TRABAJO: 
## PROGRAMACIÓN  4 -- S7A
### Intregrantes:
CRISTIAN YESID ZAMBRANO TORRES

HEIDER JOHAN CORREA PEREZ

#  Biblioteca Digital con Spring Boot

Aplicación de gestión de recursos de una biblioteca  (libros, periódicos, computadores) usando Spring Boot, Spring Data JDBC y base de datos H2 embebida.

# Utilizarios
- Java 21
- Spring Boot 3.4.4
- Spring Data JDBC
- H2 Database (embebida)
- Maven

# Funcionalidades Principales
1. Gestión de recursos:
   - Agregar libros, periódicos y computadores
   - Dar de baja recursos (marcar como inactivos)
   - Eliminar recursos inactivos
2. Búsquedas:
   - Búsqueda por criterio en todos los campos
   - Listado completo de recursos
3. Base de datos:
   - Persistencia automática con H2
   - Esquema inicial mediante `schema.sql`

# Arbol del proyecto:
src/
├── main/
│ ├── java/
│ │ └── co/edu/etitc/sistemas/tecnologo/programacion4/
│ │ │ ├── AppInfo.java
│ │ │ ├── Computador.java
│ │ │ ├── Libro.java
│ │ │ ├── Periodico.java
│ │ │ └── Recurso.java (Interfaz)
│ │ ├── repositories/
│ │ │ ├── ComputadorRepositorio.java (Interfaz)
│ │ │ ├── LibroRepositorio.java (Interfaz)
│ │ │ └── PeriodicoRepositorio.java (Interfaz)
│ │ ├── services/
│ │ │ └── ServicioBiblioteca.java
│ │ └── Main.java
│ └── resources/
│ ├── application.properties
│ └── schema.sql


## Configuración
application.properties
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
spring.h2.console.enabled=true # Consola en /h2-console
spring.sql.init.mode=always # Ejecuta schema.sql al iniciar
