package com.francoBeade.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francoBeade.crud.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
