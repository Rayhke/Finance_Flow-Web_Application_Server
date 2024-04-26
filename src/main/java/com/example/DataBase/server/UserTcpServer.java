package com.example.DataBase.server;

import com.example.DataBase.server.receiver.UserSocketReceiverImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserTcpServer {

    private static final int PORT = 13555;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Socket clientSocket = null;

        System.out.println(
            "==================================================================================" +
            "\n\n\n[ServerSocket bind 처리 후, listen 중]\n\n\n" +
            "==================================================================================");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                clientSocket = serverSocket.accept();
                Thread thread = new UserSocketReceiverImpl(clientSocket);
                thread.start();
            }
        } catch (IOException e) {
            throw new IllegalStateException(
                "==================================================================================" +
                "\n\n\n[클라이언트 소켓과의 연결 실패] : " + e + "\n\n\n" +
                "==================================================================================");
        }
    }
}