package com.hersac.orquidea.Controllers;

import java.util.List;

import com.hersac.orquidea.Models.Great;
import com.hersac.orquidea.Services.GreatService;

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
public class GreatController{

    @Autowired
    private GreatService greatService;

    @GetMapping("/greats")
    public List<Great> greatList(){
        return greatService.greatList();
    }

    @GetMapping("/great/{id}")
    public Great greatById(@PathVariable Long id){
        return greatService.greatFindById(id);
    }

    @PostMapping("/addGreat/user/{userId}/seed/{seedId}")
    public Great addGreat(@PathVariable Long userId, @PathVariable Long seedId, @RequestBody Great great){
        return greatService.greatAdd(great, userId, seedId);
    }

    @PutMapping("/updateGreat/{id}/user/{userId}/seed/{seedId}")
    public Great updateGreat(@PathVariable Long id, @PathVariable Long userId, @PathVariable Long seedId, @RequestBody Great greatInfo){
        return greatService.greatUpdate(id, greatInfo, userId, seedId);
    }

    @DeleteMapping("/deleteGreat/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return greatService.greatDelete(id);
    }

    @DeleteMapping("/deleteAllGreats")
    public ResponseEntity<?> deleteAll(){
        return greatService.deleteAll();
    }
}


