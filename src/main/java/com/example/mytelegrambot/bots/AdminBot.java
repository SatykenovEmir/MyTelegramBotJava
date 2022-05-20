package com.example.mytelegrambot.bots;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminBot {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "em01070109";
    private static final String DB_URL = "jdbc:postgresql://localhost/mydatabase";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
    }
}
