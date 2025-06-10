package com.shoppingapp.app.service.framework.DBserver;



import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingapp.app.service.core.domain.service.generater.IdGenerator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Component
public class IdGeneratorImpl implements IdGenerator {

    @PersistenceContext
    private EntityManager em;

    
    @Override
    @Transactional(readOnly = true)
    public String generate(String sequenceName) {
        String seq = "seq_" + sequenceName;

        Number val = (Number) em
            .createNativeQuery("SELECT nextval(:seqName)")
            .setParameter("seqName", seq)
            .getSingleResult();

        return sequenceName.substring(0, 3).toUpperCase() + String.format("%010d", val.longValue());
    }
}