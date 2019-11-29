package com.academy.lesson12;

import java.sql.*;

public class JDBCdemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/subscriber?user=root&password=root&serverTimezone=UTC");
        Statement statement = connection.createStatement();

/*        statement.executeUpdate("insert into abonent values(5, 'Smirnov', 'Peter', 'm', 40)");
        statement.executeUpdate("insert into abonent values(6, 'Marfa', 'White', 'f', 36)");
        statement.executeUpdate("insert into abonent values(7, 'David', 'Blame', 'm', 77)");
        statement.executeUpdate("insert into abonent values(8, 'Nina', 'Turn', 'f', 8)");
        statement.executeUpdate("insert into abonent values(9, 'Helen', 'Fri', 'f', 21)");
        statement.executeUpdate("insert into abonent values(10, 'Ben', 'Raddisson', 'f', 18)");*/
        statement.executeUpdate("update abonent set first_name = 'Dream', last_name = 'ComesTrue' where id = 6");
        statement.executeUpdate("delete from abonent where id = 9");
        ResultSet rs = statement.executeQuery("SELECT * FROM abonent");
        while (rs.next()) { // указатель на первую строку данных
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            System.out.println("id: " + id + ", firstName: " + firstName);
        }
        rs.close();
        connection.close();
    }
}
