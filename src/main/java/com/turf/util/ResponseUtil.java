package com.turf.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> createResponse(String message, Object data, boolean success) {

        Map<String, Object> response = new HashMap<>();

        response.put("message", message);
        response.put("data", data);
        response.put("success", success);

        return response;
    }
}