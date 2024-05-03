package com.example.DataBase.server.ledger.repository;

import com.example.DataBase.server.common.repository.commonJpaRepository;
import com.example.DataBase.server.ledger.entity.Ledger;

public class LedgerJpaRepository extends commonJpaRepository<Ledger, Long> {


    @Override
    protected Class<Ledger> getEntityClass() {
        return Ledger.class;
    }
}
