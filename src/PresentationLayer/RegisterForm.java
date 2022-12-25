package PresentationLayer;

import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JFrame{
    private JTextField tfName;
    private JTextField tfSurname;
    private JTextField tfRegisterMail;
    private JPasswordField pfRegisterPassword;
    private JTextField tfPhoneNumber;
    private JButton btnRegister;
    private JPanel RegisterPanel;

    public RegisterForm (){
        setTitle("Kayıt");
        setContentPane(RegisterPanel);
        setMinimumSize(new Dimension(500,524));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
