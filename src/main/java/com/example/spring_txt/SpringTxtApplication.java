package com.example.spring_txt;

import com.example.spring_txt.entity.Users;
import com.example.spring_txt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class SpringTxtApplication {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        SpringApplication.run(SpringTxtApplication.class, args);

//        File file = new File("E:\\personal_project\\user.txt");
//
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String[] splitedStr = null;
//        String line;
//        String payStr;
//        int pay;
//        List<String[]> list = null;
//
//            while ((line = br.readLine()) != null) {
//                splitedStr = line.split(",");
//
//                payStr = splitedStr[4].replace("_", "").trim();
//
//                try {
//                    pay = Integer.parseInt(payStr);
//                } catch (Exception e) {
//                    log.error("연봉 입력 값을 확인해주세요 = {}", splitedStr[1]);
//                    pay = 0;
//                }
//
//                Class.forName("org.h2.Driver");
//                String url = "jdbc:h2:mem:testdb";
//                String id = "sa";
//                String pw = "";
//                Connection con = DriverManager.getConnection(url, id, pw);
//                StringBuffer query = new StringBuffer();
//                query.append("INSERT INTO Users VALUES (?,?,?,?,?)");
//
//                PreparedStatement stmt = con.prepareStatement(query.toString());
//
//                stmt.setLong(1, Long.parseLong(splitedStr[0].trim()));
//                stmt.setInt(2, Integer.parseInt(splitedStr[2].trim()));
//                stmt.setString(3, splitedStr[3].trim());
//                stmt.setString(4, splitedStr[1].trim());
//                stmt.setInt(5, pay);
//                stmt.executeUpdate();
//            }
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
            File file = new File("E:\\personal_project\\user.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] splitedStr = null;
            String payStr;
            int pay;

            while ((line = br.readLine()) != null) {
                splitedStr = line.split(",");
                payStr = splitedStr[4].replace("_", "").trim();

                try {
                    pay = Integer.parseInt(payStr);
                } catch (Exception e) {
                    log.error("연봉 입력 값을 확인해주세요 = {}", splitedStr[1]);
                    pay = 0;
                }

                Users user = new Users(Long.parseLong(splitedStr[0].trim()), splitedStr[1].trim(), Integer.parseInt(splitedStr[2].trim()), splitedStr[3].trim(), pay);

                userRepository.save(user);
            }
        };
    }
}
