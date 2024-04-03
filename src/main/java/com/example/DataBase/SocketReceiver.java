package com.example.DataBase;

import com.example.DataBase.entity.Member;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SocketReceiver extends Thread {

    private final Socket clientSocket;

    public SocketReceiver(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * 임의로 재구성
     * */
    @Override
    public void run() {

        try(BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String result = in.readLine();
            System.out.println("\n\n[문자열 형식으로 받은 결과] : " + result + "\n\n");

            Gson gson = new Gson();
            JSONObject json = gson.fromJson(result, JSONObject.class);
            List<Map<Object, Object>> list1 = (ArrayList<Map<Object, Object>>) json.get("list");

            System.out.print("==================================================================================\n\n\n");
            for(Map<Object, Object> map : list1) {
                System.out.println("[Json 결과] : "+ map.toString());
            }
            System.out.println("\n\n\n==================================================================================");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();
                Member member = new Member(json);
                em.persist(member);
                tx.commit();
            } catch(Exception e) {
                tx.rollback();
            } finally {
                em.close(); emf.close();
            }

        } catch(IOException e) {
            throw new IllegalArgumentException(
                "==================================================================================" +
                "\n\n\n[클라이언트 소켓 입출력 연결 실패] : " + e + "\n\n\n" +
                "=================================================================================="
            );
        }
    }
}

