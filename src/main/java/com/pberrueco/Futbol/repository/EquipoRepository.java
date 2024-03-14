package com.pberrueco.Futbol.repository;

import com.pberrueco.Futbol.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findByNameContainingIgnoreCase(String name); //Para buscar por nombre

    List<Equipo> findEquipoByCountryEquals(String country);

}
