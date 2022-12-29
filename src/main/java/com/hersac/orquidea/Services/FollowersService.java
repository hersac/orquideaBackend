package com.hersac.orquidea.Services;

import java.util.List;

import com.hersac.orquidea.Models.Followers;
import com.hersac.orquidea.Models.User;
import com.hersac.orquidea.Repositories.FollowersRepository;
import com.hersac.orquidea.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FollowersService{
    @Autowired
    FollowersRepository followersRepository;

    @Autowired
    UserRepository userRepository;

    //Get
    public List<Followers> followersList(){
        return followersRepository.findAll();
    }

    public Followers followersFindById(Long id){
        return followersRepository.findById(id).orElse(null);
    }

    //Post
    public Followers followersAdd(Followers info){
        return followersRepository.save(info);
    }

    //Put
    public Followers followersUpdate(Long id, Followers info, Long followerId, Long userId){

        Followers newFollowers = followersRepository.findById(id).orElse(null);
        User newFollower = userRepository.findById(followerId).orElse(null);
        User newUser = userRepository.findById(userId).orElse(null);

        newFollowers.setFollower(newFollower);
        newFollowers.setUser(newUser);

        Followers followersUpdate = followersRepository.save(newFollowers);
        return followersUpdate;
    }

    //Delete
    public ResponseEntity<?> followDelete(Long id){
        Followers newFollowers = followersRepository.findById(id).orElse(null);
        followersRepository.delete(newFollowers);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteAll(){
        followersRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}


