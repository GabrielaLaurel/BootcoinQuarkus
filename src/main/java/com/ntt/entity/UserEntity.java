package com.ntt.entity;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MongoEntity(collection = "user")
public class UserEntity extends ReactivePanacheMongoEntity{
    //DNI - CEX - PASSAPORTE
    private String tipoDoc;
    private String numeroDoc;
    private String celular;
    private String correo;
    private double saldoInicial;
}
