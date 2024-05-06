package com.example.DataBase.server.ledger.repository;

import com.example.DataBase.server.common.repository.commonJpaRepository;
import com.example.DataBase.server.ledger.entity.Ledger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class LedgerJpaRepository extends commonJpaRepository<Ledger, Long> {

    @Autowired
    private LedgerRepository ledgerRepository;
    private final EntityManager em;

    @Autowired
    public LedgerJpaRepository(EntityManager em) {
        this.em = em;
    }

    public String saveAll(List<Ledger> list) {

        try {
            ledgerRepository.saveAll(list);

        } catch (Exception e) {

        }

        return "";
    }

    @Override
    protected Class<Ledger> getEntityClass() {
        return Ledger.class;
    }
}
