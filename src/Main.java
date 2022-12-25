import DataAccessLayer.PostgreSQL.Database;
import PresentationLayer.HomeForm;
import PresentationLayer.LoginForm;
import PresentationLayer.RegisterForm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        database.connect();
        HomeForm homeForm = new HomeForm();
    }
}