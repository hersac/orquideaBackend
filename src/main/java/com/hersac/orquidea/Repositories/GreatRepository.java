package com.hersac.orquidea.Repositories;

import com.hersac.orquidea.Models.Great;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreatRepository extends JpaRepository<Great, Long>{
}


