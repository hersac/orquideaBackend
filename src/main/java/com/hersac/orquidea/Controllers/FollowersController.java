package com.hersac.orquidea.Controllers;

import java.util.List;

import com.hersac.orquidea.Models.Followers;
import com.hersac.orquidea.Services.FollowersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class FollowersController{

    @Autowired
    private FollowersService followersService;

    @GetMapping("/followers")
    public List<Followers> followersList(){
        return followersService.followersList();
    }

    @GetMapping("/follower/{id}")
    public Followers followersById(@PathVariable Long id){
        return followersService.followersFindById(id);
    }

    @PostMapping("/addFollower")
    public Followers addFollower(@RequestBody Followers follower){
        return followersService.followersAdd(follower);
    }

    @PutMapping("/updateFollower/{id}/follower/{followerId}/user/{userId}")
    public Followers updateFollowers(@PathVariable Long id, @PathVariable Long followerId, @PathVariable Long userId, @RequestBody Followers followerInfo){
        return followersService.followersUpdate(id, followerInfo, followerId, userId);
    }

    @DeleteMapping("/deleteFollower/{id}")
    public ResponseEntity<?> deleteFollower(@PathVariable Long id){
        return followersService.followDelete(id);
    }

    @DeleteMapping("/deleteAllFollowers")
    public ResponseEntity<?> deleteAll(){
        return followersService.deleteAll();
    }

}


