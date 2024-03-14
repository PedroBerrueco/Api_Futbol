package com.pberrueco.Futbol.controller;

import com.pberrueco.Futbol.model.Equipo;
import com.pberrueco.Futbol.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/team") //Cambiando el endpoint por lo que toque
public class EquipoController {

    private final EquipoService equipoService;

    @Autowired
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping // GET AL LIST
    public ResponseEntity<List<Equipo>> getAll() {
        List<Equipo> equipos = equipoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(equipos);
    }

    @GetMapping("/{id}") //GET ONE BY ID
    public ResponseEntity<Optional<Equipo>> getById(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoService.getOne(id);
        if(equipo.isPresent()){
            return ResponseEntity.ok(equipo);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/name") //GET ONE BY NAME
    public ResponseEntity<List<Equipo>> searchName(@RequestParam String name) {
        List<Equipo> equipos = equipoService.searchByName(name);
        return ResponseEntity.ok(equipos);
    }

    @GetMapping("/country") //GET ONE BY COUNTRY
    public ResponseEntity<List<Equipo>> searchInteger(@RequestParam String country) {
        List<Equipo> equipos = equipoService.searchByCountry(country);
        return ResponseEntity.ok(equipos);
    }

    @PostMapping //POST ONE
    public ResponseEntity<Equipo> save(@RequestBody Equipo equipo){
        Equipo equipoNew = equipoService.saveOne(equipo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(equipoNew);
    }

    @PutMapping("/{id}") //PUT ONE BY ID
    public ResponseEntity<Equipo> update(@RequestBody Equipo equipo){
        Equipo equipoNew = equipoService.updateOne(equipo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(equipoNew);
    }

    @DeleteMapping("/{id}") //DELETE ON BY ID
    public ResponseEntity<String> delete(@PathVariable Long id) {
        equipoService.deleteOne(id);
        String mensaje = id + " eliminado";
        return ResponseEntity.ok().body(mensaje);
    }

}
