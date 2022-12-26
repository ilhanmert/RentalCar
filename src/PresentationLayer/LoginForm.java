package PresentationLayer;

import BusinessLogicLayer.UserManager;
import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JTextField tfLoginMail;
    private JPasswordField pfLoginPassword;
    private JButton btnLogin;
    private JButton btnRegister;
    private JPanel LoginPanel;
    private UserManager userManager = new UserManager();

    public LoginForm (){
        setTitle("Giriş");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(450,474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RegisterForm registerForm = new RegisterForm();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = userManager.checkUser(tfLoginMail.getText(),String.valueOf(pfLoginPassword.getPassword()));
                String userType = user.getUserType();
                if (userType != null && userType.equals("customer")){
                    setVisible(false);
                    HomeForm homeForm = new HomeForm(user.getId());
                }
                else if (userType != null && userType.equals("admin")){
                    HomeForm homeForm = new HomeForm(user.getId());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Giriş Başarısız! \n Lütfen Bilgilerini Kontrol Ediniz.");
                    setVisible(false);
                    LoginForm loginForm = new LoginForm();
                }
            }
        });
    }
}
