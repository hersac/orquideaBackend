package com.hersac.orquidea.Repositories;

import com.hersac.orquidea.Models.Followers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, Long>{
}


