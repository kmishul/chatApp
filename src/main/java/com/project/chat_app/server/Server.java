package com.project.chat_app.server;
import com.project.chat_app.service.ChatBackupService;
import com.project.chat_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.System.out;


public class Server {
    private static ArrayList<String> users = new ArrayList<>();
    private static ArrayList<MessagingThread> clients = new ArrayList<>();


    public static void main(String[]args) throws Exception {
        ServerSocket server = new ServerSocket(8082, 10);
        out.println("Now Server Is Running");
        while (true) {
            Socket client = server.accept();
            out.println("Client connected");
            MessagingThread thread = new MessagingThread(client);
            clients.add(thread);
            thread.start();
        }

    }

    public static void sendToAll(String user, String message) {

        for (MessagingThread c : clients) {
            if (!c.getUser().equals(user)) {
                c.sendMessage(user, message);
            }else{
                c.sendToMe(user, message);
            }
        }
    }

    static class MessagingThread extends Thread {
       // @Autowired
        UserService userService=new UserService();
        @Autowired
        ChatBackupService chatBackupService;

        String user = "";
        BufferedReader input;
        PrintWriter output;

        public MessagingThread()
        {}
        public MessagingThread(Socket client) throws Exception {

            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new PrintWriter(client.getOutputStream(), true);

            user = input.readLine();
            users.add(user);
            userService.addUserInDB(user); //check this
        }

        public void sendMessage(String chatUser, String msg) {
            output.println(chatUser + ": " + msg);
        }

        public void sendToMe(String chatUser, String msg){
            output.println("You: " + msg);
        }

        public String getUser() {
            return user;
        }

        public void saveInDB(String chatUser, String msg) throws SQLException {
            String msg_id = chatUser + "_" + System.currentTimeMillis();

           //chatBackupService.chatBackUp(user, msg_id, msg);
        }

        @Override
        public void run() {
            String line;
            try {
                while (true) {
                    line = input.readLine();
                    if (line.equals("end")) {
                        clients.remove(this);
                        users.remove(user);
                        break;
                    }else {
                        sendToAll(user, line);
                        saveInDB(user, line);
                    }
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
