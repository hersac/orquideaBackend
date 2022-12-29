package com.hersac.orquidea.Repositories;

import com.hersac.orquidea.Models.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{
}


