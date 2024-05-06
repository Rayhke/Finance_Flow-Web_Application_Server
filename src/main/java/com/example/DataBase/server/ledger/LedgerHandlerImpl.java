package com.example.DataBase.server.ledger;

import com.example.DataBase.server.ledger.repository.LedgerJpaRepository;

public class LedgerHandlerImpl implements LedgerHandler {

    private final LedgerJpaRepository ledgerJpaRepository;

    public LedgerHandlerImpl(LedgerJpaRepository ledgerJpaRepository) {
        this.ledgerJpaRepository = ledgerJpaRepository;
    }
}
