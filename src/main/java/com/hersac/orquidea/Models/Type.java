package com.hersac.orquidea.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type")
public class Type{

    //Parameters
    @Id
    @Column(name = "typeId")
    private Long typeId;

    @Column(name = "typeName")
    private String typeName;

    //Constructors
    
    public Type(){
        super();
    }

    public Type(Long typeId, String typeName){
        super();
        this.typeId = typeId;
        this.typeName = typeName;
    }

    //Methods

    public Long getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}


