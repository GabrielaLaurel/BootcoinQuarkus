package com.ntt.service;

import com.ntt.dto.ResponseDto;
import com.ntt.entity.UserEntity;

import io.smallrye.mutiny.Uni;

public interface UserService {

    Uni<ResponseDto> add(UserEntity cliente);
    Uni<ResponseDto> listAll();

}
