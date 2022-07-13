package com.shulzhenko;

import com.shulzhenko.controller.MainController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartMain implements CommandLineRunner {

    private final MainController mainController;

    public StartMain(MainController mainController) {
        this.mainController = mainController;
    }

    public static void main(String[] args) {
        SpringApplication.run(StartMain.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        mainController.run();
    }
}
