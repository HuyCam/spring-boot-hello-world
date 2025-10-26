package com.example.springhelloworld.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryLeak {
    // Static List to simulate memory leak
    public static final List<byte[]> memoryLeakList = new ArrayList<>();


    public void leak(){
        // Allocating 10MB of data every second
        try {
            int mb = 1024 * 1024 * 20;
            byte f = 1;
            byte[] somebyte = new byte[mb];

            for (int i =0 ; i < mb; i++) {
                somebyte[i] = f;
            }

            memoryLeakList.add(somebyte);
            System.out.println("Added 1MB to memoryLeakList, total size: " + memoryLeakList.size() * 20+ "MB");
        } catch (Exception e) {
            System.exit(1);
        }
    }
}
