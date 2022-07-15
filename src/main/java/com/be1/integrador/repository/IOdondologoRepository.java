package com.be1.integrador.repository;

import com.be1.integrador.model.Odontologo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IOdondologoRepository extends JpaRepository<Odontologo, Long> {
    //@Query("from Odontologos o where o.name like %:nombre%, o.lastname like %apellido%")
    //Set<Odontologo> getOdontologo(@Param("nombre") String name, @Param("apellido") String lastname);
}