package com.example.DataBase.server.transmitter;

import com.example.DataBase.unused.entity.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserSocketTransmitterImpl extends Thread implements UserSocketTransmitter {

    private final Socket clientSocket;

    public UserSocketTransmitterImpl(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            Gson gson = new Gson();
            JsonObject json;

        } catch (IOException e) {

        }
    }

    @Override
    public String save(User user) {
        return "";
    }

    @Override
    public String findByEmail(String pwd, String email) {
        return "";
    }

    @Override
    public String update(User user) {
        return "";
    }

    @Override
    public String delete(String id) {
        return "";
    }
}
