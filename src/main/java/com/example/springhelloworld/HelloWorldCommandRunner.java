package com.example.springhelloworld;

import com.example.springhelloworld.components.BotHelper;
import com.example.springhelloworld.interfaces.config.Appconfig;
import com.example.springhelloworld.services.Contents;
import com.example.springhelloworld.services.DocumentExtractor;
import com.example.springhelloworld.subjects.ObjectCreationAndDestruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldCommandRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(HelloWorldCommandRunner.class);

//    @Value("${contentOption}")
//    private String contentOption;

    @Autowired
    DocumentExtractor documentExtractor;

    @Autowired
    Appconfig appconfig;

    @Autowired
    ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
//        testBeanClassMethod();
        builderLearner();

    }

    public void testBeanClassMethod () {
        try {
            Contents contents = new Contents();
            contents.showContent("1");

            BotHelper botCoder = appconfig.botCoder();
            botCoder.talk();

            // Test regular method without Bean annotation with delay time:
            BotHelper botCoder2 = appconfig.notBotCoderBeanWithDelay();
            botCoder2.talk();

        } catch (Exception e) {

        }

    }

    public void testBeanRetrieval() {
        Contents contents = new Contents();
        contents.showContent("1");
        BotHelper botCoder = (BotHelper) context.getBean("botCoder");
        botCoder.talk();

        BotHelper botCleaner = (BotHelper) context.getBean("botCleaner");
        botCleaner.talk();
    }

    public void builderLearner() {
        ObjectCreationAndDestruction objectCreationAndDestruction = new ObjectCreationAndDestruction();

        objectCreationAndDestruction.simpleBuilder();
    }
}
