package com.ntt.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MongoEntity(collection = "solicitud")
public class SolicitudEntity extends ReactivePanacheMongoEntity{

    private String codeSolicitante;
    //Tipo de pago 1:Transaccion,  2:billetera digital
    private String modoPago;
    private Double monto;
    private String estado;

    
}
