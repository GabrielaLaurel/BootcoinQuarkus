package com.ntt.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.ntt.client.WalletClient;
import com.ntt.client.dto.BilleteraDto;
import com.ntt.dto.CompraDto;
import com.ntt.dto.ResponseDto;
import com.ntt.repository.OperationRepository;
import com.ntt.service.OperationService;
import com.ntt.service.SolicitudService;

import io.smallrye.mutiny.Uni;

public class OperationServiceImpl implements OperationService{

    @Inject
    OperationRepository repository; 

    @Inject
    SolicitudService solicitudService;

    @RestClient
    WalletClient billeteraClient;

    @Override
    public Uni<ResponseDto> AceptarCompra(CompraDto compra) {
        try {
           //if
            return solicitudService.findById(compra.getCodeSolicitud())
            /* .map(solicitud -> {
                if(solicitud.getEstado().equals(ESTADO_ACTIVO)){
                    solicitud.setEstado(ESTADO_INACTIVO);                 
                }
                return null;
            }) */
                    .map(Solicitud -> new ResponseDto(200, "Lista de Clientes en Bootcoin", Solicitud))
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin",
                            error.getMessage()));
        } catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin", ex.getMessage()));
        }   
    }

    @Override
    public Uni<ResponseDto> movimientosUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'movimientosUser'");
    }

    /**
     * @param celular
     * @return
     */
   /*  private Uni<ResponseDto> existeNumeroBilletera(String celular){
            try {
                return billeteraClient.listAll()
                .map(billeteras->{
                    List<BilleteraDto> lista = billeteras.getResponse().getClass(List<BilleteraDto>);
                for(BilleteraDto billetera: lista){
                    if(billetera.getCelular().equalsIgnoreCase(celular)){
                        return billetera;
                    }
                }
                return null;
            }).map(Solicitud -> new ResponseDto(200, "Lista de Clientes en Bootcoin", Solicitud))
            .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin",
                    error.getMessage()));
        } catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin", ex.getMessage()));
        }        
    } */
      
}
