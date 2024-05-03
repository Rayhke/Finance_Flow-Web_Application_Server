package com.example.DataBase.server;

import com.google.gson.JsonObject;

/**
 * isEmpty() [Java 6]   : 문자열 길이가 0인 경우만 true<br>
 * isBlank() [Java 11]  : 문자열 길이가 0 또는, 빈 공백인 경우 true<br><br>
 * 문자열변수이름.trim().isEmpty() == 문자열변수이름.isBlank();<hr>
 *
 * 하지만 두 메서드 모두, 문자열 null 을 감지할 순 없기 때문에 별도의 처리를 해야한다.<br>
 * <pre>{@code
 * boolean checkString(String str) {
 *     return str == null || str.trim().length() == 0;
 * }}</pre>
 * trim() 는 빈 공백을 제거하는 것
 * */
public class SelectModeImpl implements SelectMode {

    private final JsonObject json;

    public SelectModeImpl(JsonObject json) {
        this.json = json;
    }

    @Override
    public JsonObject result() {
        JsonObject result = null;

        try {
            String entity = json.get("entity").getAsString();
            String mode = json.get("mode").getAsString();

            if (checkString(entity) || checkString(mode)) {
                throw new IllegalArgumentException("[서버] : [클라이언트]에게 받은 데이터가 손상 되었습니다.");
            }

            switch (entity) {
                case "user":

                    break;
                case "ledger":

                    break;
                default:

            }

        } catch (Exception e) {
            System.out.println("[서버] : " + e.getMessage());
        }
        return result;
    }

    // private User

    private boolean checkString(String s) {
        return s == null || s.trim().length() == 0;
    }
}