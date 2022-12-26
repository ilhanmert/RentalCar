package BusinessLogicLayer;

import DataAccessLayer.PostgreSQL.Database;
import Entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager extends BaseManager {
    private Database database = new Database();
    private EncryptionManager encryptionManager = new EncryptionManager();
    public UserManager(){
        database.connect();
    }

    @Override
    public List<User> get() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = database.getUsers();
        try {
            while (resultSet.next()) {
                int id = (Integer.parseInt(resultSet.getString("id")));
                String name = (resultSet.getString("name"));
                String surname = (resultSet.getString("surname"));
                String mail = (resultSet.getString("mail"));
                String password = (resultSet.getString("password"));
                String phoneNumber = (resultSet.getString("phonenumber"));
                String userType = (resultSet.getString("usertype"));
                User user = new User(id,name,surname,mail,password,phoneNumber,userType);
                users.add(user);
            }
            return users;
        }
        catch (SQLException ex){
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean delete(int userId) {
        return null;
    }

    public boolean createUser(User user) {
        database.createUser(user.getName(), user.getSurname(), user.getMail(), user.getPassword(), user.getPhoneNumber());
        return true;
    }

    public User checkUser(String mail, String password){
        ResultSet resultSet = database.checkUser(mail, encryptionManager.Encrypt(String.valueOf(password)));
        try {
            User user = new User();
            while (resultSet.next()) {
                user.setId(Integer.parseInt(resultSet.getString("userid")));
                user.setName(resultSet.getString("username"));
                user.setSurname(resultSet.getString("usersurname"));
                user.setMail(resultSet.getString("usermail"));
                user.setPassword(resultSet.getString("userpassword"));
                user.setPhoneNumber(resultSet.getString("userphonenumber"));
                user.setUserType(resultSet.getString("usertype"));
            }
            return user;
        }
        catch (SQLException ex){
            throw new RuntimeException();
        }
    }
}
