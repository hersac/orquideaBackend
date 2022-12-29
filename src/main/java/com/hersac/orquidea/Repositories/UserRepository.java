package com.hersac.orquidea.Repositories;

import com.hersac.orquidea.Models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query(value = "SELECT * FROM user u WHERE u.user_email = ?1", nativeQuery = true)
    public User findByEmailUser(String email);

}


