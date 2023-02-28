package com.ntt.client;


import com.ntt.client.dto.BilleteraDto;
import com.ntt.dto.ResponseDto;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;

@RegisterRestClient
@Path("/api/wallet")
public interface WalletClient {

    @POST
    Uni<ResponseDto> add(BilleteraDto billeteraDto);
    @GET
    Uni<ResponseDto> listAll();

  
}
