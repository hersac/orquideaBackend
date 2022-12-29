package com.hersac.orquidea.Services;

import java.util.List;

import com.hersac.orquidea.Models.Type;
import com.hersac.orquidea.Repositories.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TypeService{

    @Autowired
    TypeRepository typeRepository;

    //Get
    public List<Type> typeList(){
        return typeRepository.findAll();
    }

    public Type typeFindById(Long id){
        return typeRepository.findById(id).orElse(null);
    }

    //Post
    public Type typeAdd(Type info){
        return typeRepository.save(info);
    }

    //Put
    public Type typeUpdate(Long id, Type info){
        Type newType = typeRepository.findById(id).orElse(null);

        newType.setTypeName(info.getTypeName());

        Type typeUpdate = typeRepository.save(newType);
        return typeUpdate;
    }

    //Delete
    public ResponseEntity<?> typeDelete(Long id){
        Type type = typeRepository.findById(id).orElse(null);
        typeRepository.delete(type);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteAll(){
        typeRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}


