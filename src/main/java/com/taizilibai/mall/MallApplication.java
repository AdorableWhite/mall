package com.taizilibai.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.sql.*;

@SpringBootApplication
@EnableCaching
public class MallApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MallApplication.class, args);
        //  获取当前运行环境
        Environment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.51:3306/payment", "root", "root");
            String sql = "select * from payment_info where payment_seq = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "FOWJP210113000084948");

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println(resultSet);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
