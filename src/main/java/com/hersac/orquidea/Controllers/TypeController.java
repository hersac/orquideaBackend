package com.hersac.orquidea.Controllers;

import java.util.List;

import com.hersac.orquidea.Models.Type;
import com.hersac.orquidea.Services.TypeService;

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
public class TypeController{

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public List<Type> typeList(){
        return typeService.typeList();
    }

    @GetMapping("/type/{id}")
    public Type typeById(@PathVariable Long id){
        return typeService.typeFindById(id);
    }

    @PostMapping("/addType")
    public Type addType(@RequestBody Type type){
        return typeService.typeAdd(type);
    }

    @PutMapping("/updateType/{id}")
    public Type updateType(@PathVariable Long id, @RequestBody Type typeInfo){
        return typeService.typeUpdate(id, typeInfo);
    }

    @DeleteMapping("/deleteType/{id}")
    public ResponseEntity<?> deleteType(@PathVariable Long id){
        return typeService.typeDelete(id);
    }

    @DeleteMapping("/deleteAllTypes")
    public ResponseEntity<?> deleteAll(){
        return typeService.deleteAll();
    }

}


