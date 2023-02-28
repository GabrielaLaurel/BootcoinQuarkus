package com.ntt.repository;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.ntt.entity.UserEntity;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class UserRepository {
    
    public Uni<UserEntity> add(UserEntity client) {
        return client.persist();
    }

    public Uni<List<UserEntity>> listAll() {
        return UserEntity.listAll(); 
    }
    public Uni<UserEntity> findId(String id) {
        return UserEntity.findById(id);
    }
    public Uni<UserEntity> update(UserEntity client) {
        return client.update();
    }

}
