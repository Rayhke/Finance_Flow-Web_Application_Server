package com.example.DataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class DataBaseApplication {

	@Autowired
	private MultiThreadServer multiThreadServer;


	public static void main(String[] args) {
		SpringApplication.run(DataBaseApplication.class, args);
	}

	@PostConstruct
	public void startServer() {
		multiThreadServer.startServer();
	}

	@PreDestroy
	public void stopServer() {
		multiThreadServer.stopServer();
	}
}
