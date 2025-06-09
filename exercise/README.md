# GRUPO DE TRABAJO: 
## PROGRAMACIÓN  4 -- S7B
### Intregrantes:
CRISTIAN YESID ZAMBRANO TORRES

HEIDER JOHAN CORREA PEREZ

#  Biblioteca Digital - Spring Boot + REST API

Aplicación web para gestionar recursos de una biblioteca (libros, periódicos y computadores) con backend en Spring Boot y frontend en HTML/JavaScript.

##  Tecnologías Utilizadas
- **Backend**: Java 17, Spring Boot 3.x, Spring Data JDBC,
- **Frontend**: HTML5, CSS3, JavaScript (Fetch API)
- **Base de datos**: H2 (en memoria)
- **Herramientas**: Maven 21, Bootstrap 5

##  Funcionalidades Principales
### Backend (REST API)
```http
POST    /api/recursos/libros       # Agrega un nuevo libro
POST    /api/recursos/periodicos   # Agrega un nuevo periódico
POST    /api/recursos/computadores # Agrega un nuevo computador
DELETE  /api/recursos/{id}?tipo={tipo} # Elimina un recurso
GET     /api/recursos              # Lista todos los recursos
GET     /api/recursos/buscar?criterio={texto} # Busca recursos

## Frontend


Formularios dinámicos por tipo de recurso

Tabla interactiva con filtros

Eliminación con confirmación

## La aplicación estará disponible en:
 http://localhost:8080/static/index.html