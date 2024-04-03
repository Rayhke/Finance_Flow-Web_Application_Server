package com.example.DataBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestServer {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Socket clientSocket = null;

        System.out.println(
            "==================================================================================" +
            "\n\n\n[ServerSocket bind 처리 후, listen 중]\n\n\n" +
            "==================================================================================");

        try(ServerSocket serverSocket = new ServerSocket(12555)) {
            while(true) {
                clientSocket = serverSocket.accept();
                Thread thread = new SocketReceiver(clientSocket);
                thread.start();
            }
        } catch(IOException e) {
            throw new IllegalStateException(
                "==================================================================================" +
                "\n\n\n[클라이언트 소켓과의 연결 실패] : " + e + "\n\n\n" +
                "==================================================================================");
        } finally {
            try {
                clientSocket.close();
            } catch(IOException e) {}
        }
    }
}