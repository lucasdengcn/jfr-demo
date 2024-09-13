package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class DemoController {

    @PostMapping("messages/v1/start")
    public String start() {
        //
        return "OK";
    }

    @GetMapping("messages/v1/hello")
    public String hello() {
        // generate a random int
        Random rand = new Random();
        // Generate a random int within a given range, e.g., between 1 and 100.
        int randomNumber = rand.nextInt(1000);
        System.out.println(randomNumber);
        try {
            Thread.sleep(randomNumber);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello World";
    }

    @PostMapping("messages/v1/leak")
    public String leak() {
        //
        File file = new File("./tmp.log");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("Hello World".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "OK";
    }

}
