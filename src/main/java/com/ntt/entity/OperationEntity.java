package com.ntt.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MongoEntity(collection = "opecacion")
public class OperationEntity extends ReactivePanacheMongoEntity{

    private String codeComprador;
    private String codeVendedor;
    //Tipo de pago 1:Transaccion,  2:billetera digital
    private String modoPago;
    //Tipo de pago 1:# cuenta,  2:# celular
    private String numeroPago;
    private Double monto;

    
}
