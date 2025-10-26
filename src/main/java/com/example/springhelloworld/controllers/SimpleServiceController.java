package com.example.springhelloworld.controllers;

import com.example.springhelloworld.repository.StoreRepository;
import com.example.springhelloworld.services.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SimpleServiceController {
    @Autowired
    StoreService storeService;

    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/store-operation")
    public String storeOperation() {

        return transactionalTest();
    }


    public String transactionalTest() {
        try {
            log.info("Start create store process");
            boolean result = storeService.storeOperation();
            return "Good";
        } catch (Exception e) {

            log.error("error Create store");
            return "Bad";
        }
    }
}
