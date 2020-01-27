package com.academy.generateDataViaSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MobileAppJustSQL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mobile?user=root&password=root&&serverTimezone=UTC");
        Statement statement = connection.createStatement();

        statement.executeUpdate("insert into operator(operator_id, name, address) values" +
                "(13, 'BeeLine', 'Haharina avenue 1'), " +
                "(14, 'DreamNet', 'Moskow avenue 217'), " +
                "(15, 'KharkivSun', 'Nauki avenue 14')");

        statement.executeUpdate("insert into subscriber(age, first_name, gender, last_name) values" +
                "(23, 'Denny', 'm', 'Width'), " +
                "(34, 'Kate', 'f', 'Burned'), " +
                "(43, 'Flora', 'm', 'Flower'), " +
                "(18, 'Mary', 'f', 'Kay'), " +
                "(17, 'Kay', 'm', 'Flint')");
    }
}
