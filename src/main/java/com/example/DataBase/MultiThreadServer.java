package com.example.DataBase;

import com.example.DataBase.server.SelectMode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Thread Pool
 */
public class MultiThreadServer {

    private static final int PORT = 13555;
    private static ServerSocket serverSocket = null;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static SelectMode selectMode = null;

    @Autowired
    public MultiThreadServer(SelectMode selectMode) {
        this.selectMode = selectMode;
    }

    public static void startServer() {
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(PORT);

                    while (true) {
                        Socket socket = serverSocket.accept();

                        executorService.execute(() -> {
                            try {
                                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                                System.out.println("[Server] : '" + isa.getHostName() + "'에서 연결 요청");

                                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                                String input = in.readLine();

                                Gson gson = new Gson();
                                JsonObject json = gson.fromJson(input, JsonObject.class);

                                String result = selectMode.Result(json);
                                out.write(result);
                                out.flush();

                                socket.close();
                            } catch (IOException e) {
                                throw new IllegalStateException("" + e.getMessage());
                            }
                        });

                    }

                } catch (IOException e) {
                    throw new IllegalStateException("[Port 바인딩 오류] : " + e.getMessage());
                }
            }
        };
        thread.start();
    }

    public static void stopServer() {
        try {
            serverSocket.close();
            executorService.shutdownNow();
            System.out.println("[Server] : 종료");
        } catch (IOException e) {}
    }
}
