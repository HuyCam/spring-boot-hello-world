package com.example.springhelloworld.services;

import com.example.springhelloworld.interfaces.Subject;
import com.example.springhelloworld.subjects.Logoptions;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public class Contents {
    private HashMap<String, Subject> contentMap;

    public Contents() {
        contentMap = new HashMap<>();
        contentMap.put("1", new Logoptions());

    }

    public void showContent(String order) {
        contentMap.get(order).demonstrate();
    }
}
