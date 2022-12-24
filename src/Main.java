import DataAccessLayer.PostgreSQL.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Database database = new Database();
        database.connect();
        ResultSet resultSet = database.checkUser("mert@gmail.com","mert123");
        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("usersurname"));
                System.out.println(resultSet.getString("usermail"));
                System.out.println(resultSet.getString("userpassword"));
                System.out.println(resultSet.getString("userphonenumber"));
                System.out.println(resultSet.getString("usertype"));

            }
        }
        catch (SQLException ex){
            throw new RuntimeException();
        }
        System.out.println();
    }
}