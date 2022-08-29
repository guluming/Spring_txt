package com.example.spring_txt;

import com.example.spring_txt.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@SpringBootApplication
public class SpringTxtApplication {

    public static void main(String[] args) {
        File file = new File("E:\\personal_project\\user.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] splitedStr = null;
            while((line = br.readLine()) != null) {
                splitedStr = line.split(" , ");

                User user = new User(splitedStr[0], splitedStr[1], splitedStr[2], splitedStr[3], splitedStr[4]);


            }
        } catch (Exception e) {

        }

        SpringApplication.run(SpringTxtApplication.class, args);
    }

}
