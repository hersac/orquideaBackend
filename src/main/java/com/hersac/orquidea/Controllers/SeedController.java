package com.hersac.orquidea.Controllers;

import java.util.List;

import com.hersac.orquidea.Models.Seed;
import com.hersac.orquidea.Services.SeedService;

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
@RequestMapping("data")
public class SeedController{

    @Autowired
    private SeedService seedService;

    @GetMapping("/seeds")
    public List<Seed> seedList(){
        return seedService.seedList();
    }

    @GetMapping("/seed/{id}")
    public Seed seedById(@PathVariable Long id){
        return seedService.seedFindById(id);
    }

    @PostMapping("/addSeed/user/{userId}/type/{typeId}")
    public Seed addSeed(@PathVariable Long userId, @PathVariable Long typeId, @RequestBody Seed seed){
        return seedService.seedAdd(seed, userId, typeId);
    }

    @PutMapping("/updateSeed/{id}/user/{userId}/type/{typeId}/seedRepost/{seedRepostId}")
    public Seed updateSeed(@PathVariable Long id, @PathVariable Long userId, @PathVariable Long typeId, @PathVariable Long seedRepostId, @RequestBody Seed seedInfo){
        return seedService.seedUpdate(id, seedInfo, userId, typeId, seedRepostId);
    }

    @DeleteMapping("/deleteSeed/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return seedService.seedDelete(id);
    }

    @DeleteMapping("/deleteAllSeeds")
    public ResponseEntity<?> deleteAll(){
        return seedService.deleteAll();
    }

}


