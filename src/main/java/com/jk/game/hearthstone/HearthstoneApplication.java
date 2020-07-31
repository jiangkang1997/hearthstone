package com.jk.game.hearthstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author jk
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class  HearthstoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(HearthstoneApplication.class, args);

    }

}
