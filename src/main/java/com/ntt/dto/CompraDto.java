package com.ntt.dto;

import lombok.Data;

@Data
public class CompraDto {
    
    private String bootcoinCelular;
    //Tipo de pago 1:Transaccion,  2:billetera digital
    private String codeSolicitud;
    //Tipo de pago 1:# cuenta,  2:# celular
    private String numeroPago;
}
