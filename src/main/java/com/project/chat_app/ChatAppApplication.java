package com.project.chat_app;
import com.project.chat_app.client.Client2;
import com.project.chat_app.server.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatAppApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ChatAppApplication.class, args);
//       SpringApplication.run(com.project.chat_app.server.Server.class, args);
//        SpringApplication.run(com.project.chat_app.client.Client1.class, args);
//        SpringApplication.run(com.project.chat_app.client.Client2.class, args);
//        ClassLoader classLoader = ChatAppApplication.class.getClassLoader();
//        classLoader.loadClass("com.project.chat_app.server.Server");
//        classLoader.loadClass("com.project.chat_app.client.Client1.class");
//        classLoader.loadClass("com.project.chat_app.client.Client2.class");



    }


    @Override
    public void run(String... args) throws Exception {
        Server.main();
    }
}
