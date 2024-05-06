package com.example.DataBase.server.ledger.repository;

import com.example.DataBase.server.ledger.entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerRepository extends JpaRepository<Ledger, Long> {

}