package com.example.DataBase;

import com.example.DataBase.server.SelectMode;
import com.example.DataBase.server.SelectModeImpl;
import com.example.DataBase.server.ledger.LedgerHandler;
import com.example.DataBase.server.ledger.LedgerHandlerImpl;
import com.example.DataBase.server.ledger.repository.LedgerJpaRepository;
import com.example.DataBase.server.ledger.repository.LedgerRepository;
import com.example.DataBase.server.user.UserHandler;
import com.example.DataBase.server.user.UserHandlerImpl;
import com.example.DataBase.server.user.repository.UserJpaRepository;
import com.example.DataBase.server.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class Config {

    private final LedgerRepository ledgerRepository;
    private final EntityManager em;

    @Autowired
    public Config(LedgerRepository ledgerRepository, EntityManager em) {
        this.ledgerRepository = ledgerRepository;
        this.em = em;
    }

    // ====================================================

    @Bean
    public MultiThreadServer multiThreadServer() {
        return new MultiThreadServer(selectMode());
    }

    @Bean
    public SelectMode selectMode() {
        return new SelectModeImpl(userHandler(), ledgerHandler());
    }

    // ====================================================

    @Bean
    public UserHandler userHandler() {
        return new UserHandlerImpl(userJpaRepository());
    }

    @Bean
    public UserRepository userJpaRepository() {
        return new UserJpaRepository(em);
    }

    // ====================================================

    @Bean
    public LedgerHandler ledgerHandler() {
        return new LedgerHandlerImpl(customLedgerRepository());
    }

    @Bean
    public LedgerJpaRepository customLedgerRepository() {
        return new LedgerJpaRepository(em);
    }
}
