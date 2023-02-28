package com.ntt.service.impl;

import com.ntt.dto.ResponseDto;
import com.ntt.dto.SolicitudDto;
import com.ntt.entity.SolicitudEntity;
import com.ntt.repository.SolicitudRepository;
import com.ntt.service.SolicitudService;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class SolicitudServiceImpl implements SolicitudService {

    @Inject
    SolicitudRepository repository;

    final private static String ESTADO_ACTIVO ="A";
    final private static String ESTADO_INACTIVO ="I";
    @Override
    public Uni<ResponseDto> add(SolicitudEntity solicitud) {
        try {
            solicitud.setEstado(ESTADO_ACTIVO);
            return repository.add(solicitud)
                    .map(Solicitud -> new ResponseDto(201, "Exito", Solicitud))
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error", error.getMessage()));
             
        }catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - Exception", ex.getMessage()));
        }       
    }
    @Override
    public Uni<ResponseDto> listAllActive() {
        try {
            return repository.listAll()
            .map(solicitudes -> {
                List<SolicitudDto> lista = new ArrayList<>();

                for (SolicitudEntity solicitud : solicitudes) {
                    if(solicitud.getEstado().equals(ESTADO_ACTIVO)){
                        SolicitudDto solicitudDto = new SolicitudDto();
                        solicitudDto.setCodeSolicitud(solicitud.id.toString());
                        solicitudDto.setMonto(solicitud.getMonto());
                        solicitudDto.setModoPago(solicitud.getModoPago());
                        lista.add(solicitudDto);
                    }
                    
                }

                return lista;
            })
                    .map(Solicitud -> new ResponseDto(200, "Lista de Clientes en Bootcoin", Solicitud))
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin",
                            error.getMessage()));
        } catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin", ex.getMessage()));
        }   
    }
    @Override
    public Uni<ResponseDto> listAll() {
        try {
            return repository.listAll()
                    .map(Solicitud -> new ResponseDto(200, "Lista de Clientes en Bootcoin", Solicitud))
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin",
                            error.getMessage()));
        } catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin", ex.getMessage()));
        }
    }

    @Override
    public Uni<ResponseDto> terminar(String solicitudId) {
        try {
            return repository.remove(solicitudId)
                    .map(Solicitud -> new ResponseDto(200, "Lista de Clientes en Bootcoin", Solicitud))
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin",
                            error.getMessage()));
        } catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin", ex.getMessage()));
        }   
    }
    @Override
    public Uni<ResponseDto> findById(String solicitud) {
        try {
            return repository.findId(solicitud)
                    .map(Solicitud -> new ResponseDto(200, "Lista de Clientes en Bootcoin", Solicitud))
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin",
                            error.getMessage()));
        } catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin", ex.getMessage()));
        }   
    }
    

    
}
