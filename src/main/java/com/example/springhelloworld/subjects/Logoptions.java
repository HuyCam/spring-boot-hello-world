package com.example.springhelloworld.subjects;

import com.example.springhelloworld.HelloWorldCommandRunner;
import com.example.springhelloworld.interfaces.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logoptions implements Subject {
    Logger logger = LoggerFactory.getLogger(HelloWorldCommandRunner.class);

    @Override
    public void demonstrate() {
        logger.info("Hello World");
        logger.info("This is your first start to run a spring boot application");
        logger.info("This is a test for long process running");

        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
    }
}
