package com.ntt.service.impl;

import com.ntt.dto.ResponseDto;
import com.ntt.entity.UserEntity;
import com.ntt.repository.UserRepository;
import com.ntt.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class UserServiceImpl implements UserService {
   
    @Inject
    UserRepository repository;
    @Override
    public Uni<ResponseDto> add(UserEntity cliente) {
        try {
                          
            return repository.add(cliente)
                    .map(user -> new ResponseDto(201, "Exito", user))
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error", error.getMessage()));
             
        }catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - Exception", ex.getMessage()));
        }       
    }

    @Override
    public Uni<ResponseDto> listAll() {
        try {
            return repository.listAll()
                    .map(user -> new ResponseDto(200, "Lista de Clientes en Bootcoin", user))
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin",
                            error.getMessage()));
        } catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, "Error - No se puede mostrar clientes de Bootcoin", ex.getMessage()));
        }
    }

}
