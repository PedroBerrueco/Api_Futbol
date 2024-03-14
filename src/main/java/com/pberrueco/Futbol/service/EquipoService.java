package com.pberrueco.Futbol.service;

import com.pberrueco.Futbol.model.Equipo;
import com.pberrueco.Futbol.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    EquipoRepository equipoRepository;

    public List<Equipo> getAll() { return equipoRepository.findAll(); }
    public Optional<Equipo> getOne(Long id){
        return equipoRepository.findById(id);
    }
    public Equipo saveOne(Equipo book){
        return equipoRepository.save(book);
    }
    public Equipo updateOne(Equipo book){
        return equipoRepository.save(book);
    }
    public void deleteOne(Long id){
        equipoRepository.deleteById(id);
    }
    public List<Equipo> searchByName(String name){ return equipoRepository.findByNameContainingIgnoreCase(name);}
    public List<Equipo> searchByCountry(String country){ return equipoRepository.findEquipoByCountryEquals(country);}


}
