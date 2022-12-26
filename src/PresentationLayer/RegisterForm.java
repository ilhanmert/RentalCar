package PresentationLayer;

import BusinessLogicLayer.EncryptionManager;
import BusinessLogicLayer.UserManager;
import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame{
    private JTextField tfName;
    private JTextField tfSurname;
    private JTextField tfRegisterMail;
    private JPasswordField pfRegisterPassword;
    private JTextField tfPhoneNumber;
    private JButton btnRegister;
    private JPanel RegisterPanel;
    private UserManager userManager = new UserManager();
    private EncryptionManager encryptionManager = new EncryptionManager();

    public RegisterForm (){
        setTitle("Kayıt");
        setContentPane(RegisterPanel);
        setMinimumSize(new Dimension(500,524));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = encryptionManager.Encrypt(String.valueOf(pfRegisterPassword.getPassword()));
                User user = new User(tfName.getText(),tfSurname.getText(),tfRegisterMail.getText(),password,tfPhoneNumber.getText());
                boolean status = userManager.createUser(user);
                if (status){
                    JOptionPane.showMessageDialog(null,"Kayıt Başarılı! \n Lütfen Giriş Yapınız.");
                    setVisible(false);
                    LoginForm loginForm = new LoginForm();
                }
            }
        });
    }
}
