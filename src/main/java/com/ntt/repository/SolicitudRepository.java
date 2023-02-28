package com.ntt.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.bson.types.ObjectId;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ntt.entity.SolicitudEntity;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class SolicitudRepository {
    @ConfigProperty(name = "valor.flag.activo")
    String flag_activo;

    @ConfigProperty(name = "valor.flag.inactivo")
    String flag_inactivo;
    
    public Uni<SolicitudEntity> add(SolicitudEntity op) {
        return op.persist();
    }

    public Uni<List<SolicitudEntity>> listAll() {
        return SolicitudEntity.listAll(); 
    }
    public Uni<SolicitudEntity> findId(String id) {
        return SolicitudEntity.findById(id);
    }
    public Uni<SolicitudEntity> update(SolicitudEntity op) {
        return op.update();
    }

    public Uni<SolicitudEntity> remove(String id) {
        Uni<SolicitudEntity> solicitud = SolicitudEntity.findById(new ObjectId(id));
        return solicitud.map(item -> {
            item.setEstado(flag_inactivo);
            return item;
        }).call(item -> {
            return item.persistOrUpdate();
        });
    }

}
