package com.example.DataBase.server.receiver;

import com.example.DataBase.unused.entity.User;
import com.example.DataBase.server.repository.UserJpaRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

@Component
public class UserSocketReceiverImpl extends Thread implements UserSocketReceiver {

    private final Socket clientSocket;

    public UserSocketReceiverImpl(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * 임의로 재구성
     * */
    @Override
    public void run() {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String result = in.readLine();
            System.out.println("\n\n[문자열 형식으로 받은 결과] : " + result + "\n\n");

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(result, JsonObject.class);

            String mode = json.get("mode").getAsString();
            User user = new User(json.getAsJsonObject("userDTO"));

            // selectMode(mode, user);

            System.out.println("[수행한 절차 : " + mode + " / 반환 결과 : " + selectMode(mode, user) + "]");

        } catch (IOException e) {
            throw new IllegalArgumentException(
                "==================================================================================" +
                "\n\n\n[클라이언트 소켓 입출력 연결 실패] : " + e + "\n\n\n" +
                "=================================================================================="
            );
        }
    }

    @Override
    public String selectMode(String mode, User user) {
        String result;
        
        switch (mode) {
            case "save":
                result = save(user);
                break;
            case "findByEmail":
                result = findByEmail(user.getPwd(), user.getEmail());
                break;
            case "update":
                result = update(user);
                break;
            case "delete":
                result = delete(user.getId());
                break;
            default:
                result = "purpose:error/class:UserSocketReceiverImpl/method:selectMode/reason:Wrong input mode";
        }
        return result;
    }

    @Override
    public String save(User user) {
        UserJpaRepository jpa = new UserJpaRepository();
        return jpa.save(user);
    }

    @Override
    public String findByEmail(String pwd, String email) {
        UserJpaRepository jpa = new UserJpaRepository();
        return jpa.findByEmail(pwd, email);
    }

    @Override
    public String update(User user) {
        UserJpaRepository jpa = new UserJpaRepository();
        return jpa.update(user);
    }

    @Override
    public String delete(String id) {
        UserJpaRepository jpa = new UserJpaRepository();
        return jpa.delete(id);
    }
}