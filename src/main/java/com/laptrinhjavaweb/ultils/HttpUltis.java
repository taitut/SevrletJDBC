package com.laptrinhjavaweb.ultils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUltis {
    public String value;

    public HttpUltis(String value) {
        this.value = value;

    }

    public <T> T toModel(Class<T> tClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(value, tClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static HttpUltis of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return new HttpUltis(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
