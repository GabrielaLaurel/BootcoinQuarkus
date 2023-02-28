package com.ntt.resource;

import com.ntt.dto.ClienteDto;
import com.ntt.dto.ResponseDto;
import com.ntt.entity.UserEntity;
import com.ntt.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;


import io.smallrye.mutiny.Uni;

@Path("/api/billetera/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService clientService;

    @POST
    @Operation(summary = "Registrar cliente billetera ",description = "Registrar en billetera")
    public Uni<ResponseDto> add(UserEntity cliente) {
        return clientService.add(cliente);
    }
    @Path("/wallet")
    @POST
    @Operation(summary = "Registrar cliente billetera ",description = "Registrar en billetera")
    public Uni<ResponseDto> addBilletera(ClienteDto dto) {
        System.out.println("controller addbillere");
        System.out.println();
        return clientService.addBilletera(dto);
    }

    @GET
    @Operation(summary = "Obtener clientes",description = "Obtiener los clientes totales con billeteras")
    public Uni<ResponseDto> listAll() {
        return clientService.listAll();
    }

}
