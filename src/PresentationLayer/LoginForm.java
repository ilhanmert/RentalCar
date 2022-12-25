package PresentationLayer;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame{
    private JTextField tfLoginMail;
    private JPasswordField pfLoginPassword;
    private JButton btnLogin;
    private JButton btnRegister;
    private JPanel LoginPanel;

    public LoginForm (){
        setTitle("Giriş");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(450,474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
