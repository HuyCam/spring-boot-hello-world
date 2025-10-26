package com.example.springhelloworld.subjects;

import com.example.springhelloworld.HelloWorldCommandRunner;
import com.example.springhelloworld.interfaces.Subject;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Logoptions implements Subject {

    @Override
    public void demonstrate() {
        log.info("Hello World");
        log.info("This is your first start to run a spring boot application");
        log.info("This is a test for long process running");

        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
    }

    @Override
    public void headerCreation() {

    }
}
