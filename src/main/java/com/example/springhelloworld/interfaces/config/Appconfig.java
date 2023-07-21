package com.example.springhelloworld.interfaces.config;

import com.example.springhelloworld.components.BotHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.example.springhelloworld")
public class Appconfig {
    @Bean (name = "botCoder")
    public BotHelper botCoder() throws InterruptedException {
        TimeUnit.SECONDS.sleep(15);
        BotHelper bot = new BotHelper("Bob", "Coder");
        return bot;
    }

    @Bean (name = "botCleaner")
    public BotHelper botCleaner() {
        BotHelper bot = new BotHelper("Daisy", "Cleaner");
        return bot;
    }


    public BotHelper notBotCoderBeanWithDelay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(15);
        BotHelper bot = new BotHelper("Bob", "Coder");
        return bot;
    }
}
