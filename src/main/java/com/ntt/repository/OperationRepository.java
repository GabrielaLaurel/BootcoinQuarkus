package com.ntt.repository;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.ntt.entity.OperationEntity;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class OperationRepository {
    
    public Uni<OperationEntity> add(OperationEntity op) {
        return op.persist();
    }

    public Uni<List<OperationEntity>> listAll() {
        return OperationEntity.listAll(); 
    }
    public Uni<OperationEntity> findId(String id) {
        return OperationEntity.findById(id);
    }
    public Uni<OperationEntity> update(OperationEntity op) {
        return op.update();
    }

}
