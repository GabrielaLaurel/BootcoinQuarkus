package com.ntt.service;

import com.ntt.dto.CompraDto;
import com.ntt.dto.ResponseDto;

import io.smallrye.mutiny.Uni;

public interface OperationService {

    Uni<ResponseDto> AceptarCompra(CompraDto compra);
    Uni<ResponseDto> movimientosUser();

}
