package com.ntt.service;

import com.ntt.dto.ResponseDto;
import com.ntt.entity.SolicitudEntity;

import io.smallrye.mutiny.Uni;

public interface SolicitudService {

    Uni<ResponseDto> add(SolicitudEntity solicitud);
    Uni<ResponseDto> terminar(String solicitud);
    Uni<ResponseDto> findById(String solicitud);
    Uni<ResponseDto> listAllActive();    
    Uni<ResponseDto> listAll();

}
