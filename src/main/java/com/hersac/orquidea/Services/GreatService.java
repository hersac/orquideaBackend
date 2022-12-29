package com.hersac.orquidea.Services;

import java.util.List;

import com.hersac.orquidea.Models.Great;
import com.hersac.orquidea.Models.Seed;
import com.hersac.orquidea.Models.User;
import com.hersac.orquidea.Repositories.GreatRepository;
import com.hersac.orquidea.Repositories.SeedRepository;
import com.hersac.orquidea.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GreatService{

    @Autowired
    GreatRepository greatRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SeedRepository seedRepository;

    //Get
    public List<Great> greatList(){
        return greatRepository.findAll();
    }

    public Great greatFindById(Long id){
        return greatRepository.findById(id).orElse(null);
    }

    //Post
    public Great greatAdd(Great info, Long userId, Long seedId){

        User user = userRepository.findById(userId).orElse(null);
        Seed seed = seedRepository.findById(seedId).orElse(null);

        info.setUser(user);
        info.setSeed(seed);

        return greatRepository.save(info);
    }

    //Put
    public Great greatUpdate(Long id, Great info, Long userId, Long seedId){

        Great newGreat = greatRepository.findById(id).orElse(null);
        User newUser = userRepository.findById(userId).orElse(null);
        Seed newSeed = seedRepository.findById(seedId).orElse(null);

        newGreat.setGreatCreationDate(info.getGreatCreationDate());
        newGreat.setUser(newUser);
        newGreat.setSeed(newSeed);

        Great greatUpdate = greatRepository.save(newGreat);
        return greatUpdate;
    }

    //Delete
    public ResponseEntity<?> greatDelete(Long id){
        Great newGreat = greatRepository.findById(id).orElse(null);
        greatRepository.delete(newGreat);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteAll(){
        greatRepository.deleteAll();
        return ResponseEntity.ok().build();
    }


}


