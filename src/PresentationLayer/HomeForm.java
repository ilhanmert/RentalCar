package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeForm extends JFrame {

    private JLabel jlAdverts;
    private JTable jtAdverts;
    private JPanel HomePanel;
    private JButton btnAdverts;
    private JButton btnMyAdverts;
    private JButton btnReservations;
    private JButton btnMyReservations;
    private JButton btnCreateAdvert;
    private JTextField tfAdvertNo;
    private JTextField tfFirstDate;
    private JTextField tfLastDate;
    private JButton btnCreateReservation;
    private JButton btnLogout;

    public HomeForm (){
        setTitle("Anasayfa");
        setContentPane(HomePanel);
        setMinimumSize(new Dimension(1000,800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jtAdverts.getTableHeader();
        setVisible(true);

        btnAdverts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                HomeForm homeForm = new HomeForm();
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginForm loginForm = new LoginForm();
            }
        });
    }
}
