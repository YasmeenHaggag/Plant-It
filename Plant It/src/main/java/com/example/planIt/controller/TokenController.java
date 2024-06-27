package com.example.planIt.controller;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;
import java.util.Map;

@RestController
public class TokenController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/extract-id")
    public String parseToken(@RequestParam String token) {
        try {
            String[] components = token.split("\\.");
            if (components.length != 3) {
                return "Invalid token format";
            }
            String payload = new String(Base64.getDecoder().decode(components[1]));
            Map<String, Object> claims = objectMapper.readValue(payload, Map.class);
            Object id = claims.get("id");

            return id != null ? id.toString() : "ID not found ";
        } catch (Exception e) {
            return "Invalid token: ";
        }
    }
}

