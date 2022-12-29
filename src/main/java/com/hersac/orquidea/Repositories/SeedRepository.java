package com.hersac.orquidea.Repositories;

import com.hersac.orquidea.Models.Seed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Long>{
}


