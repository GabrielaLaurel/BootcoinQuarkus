package com.ntt.client.dto;

import lombok.Data;

@Data
public class BilleteraDto {
    private String idBilletera;
    private String codigoCliente;
    private String celular;
    private Double monto;
    private String estado;
}
