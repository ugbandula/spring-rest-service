package com.test.springrest.shared;

/**
 * Created by Bandula Gamage on 28/06/2015.
 */
public class SharedMethods {

    public static String generateStatus(String method, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"id\":");
        stringBuilder.append(method);
        stringBuilder.append(",");
        stringBuilder.append("\"message\":");
        stringBuilder.append(message);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
