package edu.wgu.d387_sample_code.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class WelcomeController {

    @GetMapping("/welcome")
    public String[] getWelcomeMessages() {
        String[] welcomeMessages = new String[2];

        Thread englishThread = new Thread(() -> {
            welcomeMessages[0] = new WelcomeMessage("en", "US").getWelcomeMessage();
        });

        Thread frenchThread = new Thread(() -> {
            welcomeMessages[1] = new WelcomeMessage("fr", "CA").getWelcomeMessage();
        });

        englishThread.start();
        frenchThread.start();

        try {
            englishThread.join();
            frenchThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new String[]{"Error", "Error"};
        }

        return welcomeMessages;
    }
}