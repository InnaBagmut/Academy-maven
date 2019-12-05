/*Добавить в БД Mobile используя sql запросы:
        - 3 мобильных оператора
        - 5 абонентов
        - 9 мобильных номеров (3 номера для каждого оператора)
        - добавить в телефонную книгу 5 абонентов, присвоив каждому по номеру
        package com.academy.lesson12;*/

//package com.academy.lesson12;

import java.sql.*;

public class JDBCdemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/subscriber?user=root&password=root&&serverTimezone=UTC");
        Statement statement = connection.createStatement();

        //statement.executeUpdate("insert into abonent values(5, 'Smirnov', 'Peter', 'm', 40)");
        //statement.executeUpdate("update abonent set first_name = 'Dream', last_name = 'ComesTrue' where id = 6");
        //statement.executeUpdate("insert into abonent(first_name, last_name, gender, age) values('Lucky', 'Strike', 'm', 44)");
        //statement.executeUpdate("delete from abonent where id = 9");
        //String.format("select from {0} where {1} = {}", Table1, col1, id1)
        //String.format("insert into {abonent(first_name, last_name, gender, age)}", "Mike", "Sunday", "m", 32);

        statement.executeUpdate("insert into operator(id, name, address, fee) values" +
                "(4, 'BeeLine', 'Haharina avenue 1', 23), " +
                "(5, 'DreamNet', 'Moskow avenue 217', 56), " +
                "(6, 'KharkivSun', 'Nauki avenue 14', 24)");

        statement.executeUpdate("insert into abonent(first_name, last_name, gender, age) values" +
                "('Denny', 'Width', 'm', 43), " +
                "('Kate', 'Burned', 'f', 22), " +
                "('Flora', 'Flower', 'f', 32), " +
                "('Mary', 'Kay', 'f', 65), " +
                "('Kay', 'Flint', 'f', 43)");

        statement.executeUpdate("insert into operator_number(number, operator_id) values" +
                "('380475564823', 4), " +
                "('380495672004', 5), " +
                "('380275964123', 6)");

        statement.executeUpdate("insert into phone_book(number, abonent_id, registered_date) values" +
                "('380475564823', 17, '2019-11-30 14:55:56'), " +
                "('380495672004', 18, '2019-12-30 14:55:56')");

/*        statement.executeUpdate("insert into phone_book(number, abonent_id, registered_date) values" +
                "((select number from operator_number where operator_id = 17), 2, '2019-11-30 14:55:56'), " +
                "((select number from operator_number where operator_id = 18), 3, '2019-12-30 14:55:56')");*/


        ResultSet rs1 = statement.executeQuery("SELECT * FROM abonent");
        while (rs1.next()) { // указатель на первую строку данных
            int id = rs1.getInt("id");
            String firstName = rs1.getString("first_name");
            System.out.println("id: " + id + ", firstName: " + firstName);
        }

        System.out.println("========================================================");

        System.out.println("Выводим всех абонентов заданного мобильного оператора:");
        ResultSet rs2 = statement.executeQuery("SELECT first_name, last_name FROM abonent where id in" +
                "(select abonent_id from phone_book where number in" +
                "(select number from operator_number where operator_id in" +
                "(select id from operator where name = 'Life')))");
        while (rs2.next()) {
            String firstName = rs2.getString("first_name");
            String lastName = rs2.getString("last_name");
            System.out.println("Life user: " + " first name: " + firstName + ", last name: " + lastName);
        }

        rs1.close();
        rs2.close();
        connection.close();
    }
}
