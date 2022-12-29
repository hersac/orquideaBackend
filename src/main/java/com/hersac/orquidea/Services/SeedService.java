package com.hersac.orquidea.Services;

import java.util.List;

import com.hersac.orquidea.Models.Seed;
import com.hersac.orquidea.Models.Type;
import com.hersac.orquidea.Models.User;
import com.hersac.orquidea.Repositories.SeedRepository;
import com.hersac.orquidea.Repositories.TypeRepository;
import com.hersac.orquidea.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SeedService{
    @Autowired
    SeedRepository seedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TypeRepository typeRepository;

    //Get
    public List<Seed> seedList(){
        return seedRepository.findAll();
    }

    public Seed seedFindById(Long id){
        return seedRepository.findById(id).orElse(null);
    }

    //Post
    public Seed seedAdd(Seed info, Long userId, Long typeId){
        User user = userRepository.findById(userId).orElse(null);
        Type type = typeRepository.findById(typeId).orElse(null);

        info.setUser(user);
        info.setSeedType(type);

        return seedRepository.save(info);
    }

    //Put
    public Seed seedUpdate(Long id, Seed info, Long userId, Long typeId, Long seedRepostId){

        Seed newSeed = seedRepository.findById(id).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        Type type = typeRepository.findById(typeId).orElse(null);
        Seed seedRepost = seedRepository.findById(seedRepostId).orElse(null);

        newSeed.setSeedText(info.getSeedText());
        newSeed.setSeedCreationDate(info.getSeedCreationDate());
        newSeed.setUser(user);
        newSeed.setSeedShare(seedRepost);
        newSeed.setSeedImage1(info.getSeedImage1());
        newSeed.setSeedImage2(info.getSeedImage2());
        newSeed.setSeedImage3(info.getSeedImage3());
        newSeed.setSeedImage4(info.getSeedImage4());
        newSeed.setSeedImage5(info.getSeedImage5());
        newSeed.setSeedGif(info.getSeedGif());
        newSeed.setSeeVideo(info.getSeeVideo());
        newSeed.setSeedType(type);

        Seed seedUpdate = seedRepository.save(newSeed);
        return seedUpdate;
    }

    //Delete
    public ResponseEntity<?> seedDelete(Long id){
        Seed seed = seedRepository.findById(id).orElse(null);
        seedRepository.delete(seed);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteAll(){
        seedRepository.deleteAll();
        return ResponseEntity.ok().build();
    }


}


