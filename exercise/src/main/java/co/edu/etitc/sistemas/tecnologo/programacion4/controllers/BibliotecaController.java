package co.edu.etitc.sistemas.tecnologo.programacion4.controllers;

import co.edu.etitc.sistemas.tecnologo.programacion4.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api/recursos")
public class BibliotecaController {

    private final ServicioBiblioteca servicio;
    private final LibroRepositorio libroRepositorio;
    private final PeriodicoRepositorio periodicoRepositorio;
    private final ComputadorRepositorio computadorRepositorio;

    public BibliotecaController(ServicioBiblioteca servicio,
                              LibroRepositorio libroRepositorio,
                              PeriodicoRepositorio periodicoRepositorio,
                              ComputadorRepositorio computadorRepositorio) {
        this.servicio = servicio;
        this.libroRepositorio = libroRepositorio;
        this.periodicoRepositorio = periodicoRepositorio;
        this.computadorRepositorio = computadorRepositorio;
    }

    @GetMapping
    public Collection<Recurso> obtenerRecursos(
        @RequestParam(name = "criterio", required = false) String criterio) {
        
        if (criterio != null && !criterio.trim().isEmpty()) {
            return servicio.buscarRecursos(criterio);
        } else {
            return servicio.obtenerTodos();
        }
    }

    @PostMapping("/libros")
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        Libro libroGuardado = libroRepositorio.save(libro);
        return ResponseEntity.ok(libroGuardado);
    }

    @PostMapping("/periodicos")
    public ResponseEntity<Periodico> agregarPeriodico(@RequestBody Periodico periodico) {
        Periodico periodicoGuardado = periodicoRepositorio.save(periodico);
        return ResponseEntity.ok(periodicoGuardado);
    }

    @PostMapping("/computadores")
    public ResponseEntity<Computador> agregarComputador(@RequestBody Computador computador) {
        Computador computadorGuardado = computadorRepositorio.save(computador);
        return ResponseEntity.ok(computadorGuardado);
    }

        @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecurso(
        @PathVariable("id") Integer id,
        @RequestParam("tipo") String tipo) {
        
        servicio.quitarRecurso(id, tipo);
        return ResponseEntity.noContent().build();
    }


}