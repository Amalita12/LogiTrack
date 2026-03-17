package org.example.logitrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogiTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogiTrackApplication.class, args);
        System.out.println("====================================");
        System.out.println("  LogiTrack démarré !");
        System.out.println("  http://localhost:8081");
        System.out.println("====================================");
    }

}
