package com.example.springhelloworld;

import com.example.springhelloworld.components.BotHelper;
import com.example.springhelloworld.interfaces.config.Appconfig;
import com.example.springhelloworld.services.Contents;
import com.example.springhelloworld.services.DocumentExtractor;
import com.example.springhelloworld.services.MemoryLeak;
import com.example.springhelloworld.services.StoreService;
import com.example.springhelloworld.subjects.ObjectCreationAndDestruction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class HelloWorldCommandRunner implements CommandLineRunner {


//    @Value("${contentOption}")
//    private String contentOption;

    @Autowired
    DocumentExtractor documentExtractor;

    @Autowired
    Appconfig appconfig;

    @Autowired
    ApplicationContext context;
    @Autowired
    MemoryLeak memoryLeak;


    @Override
    public void run(String... args) throws Exception {
//        testBeanClassMethod();
        //builderLearner();

        System.out.println("hello");
    }

    public void createMemoryLeak() {
        try {
            memoryLeak.leak();
        } catch (Exception e) {
            System.exit(1);
        }
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
