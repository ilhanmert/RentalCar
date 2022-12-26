package PresentationLayer;

import BusinessLogicLayer.AdvertManager;
import Entities.Advert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAdvertForm extends JFrame {
    private JButton btnLogout;
    private JButton btnAdverts;
    private JButton btnMyAdverts;
    private JButton btnCreateAdvert;
    private JButton btnMyReservations;
    private JButton btnReservations;
    private JTextField tfBrand;
    private JTextField tfModel;
    private JTextField tfYear;
    private JTextField tfFuelAmount;
    private JTextField tfPrice;
    private JButton btnCreateAdvertDB;
    private JPanel CreateAdvertPanel;
    private AdvertManager advertManager = new AdvertManager();

    public CreateAdvertForm(int userId){
        setTitle("İlan Açma");
        setContentPane(CreateAdvertPanel);
        setMinimumSize(new Dimension(500,524));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btnCreateAdvertDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Advert advert = new Advert(userId,tfBrand.getText(),tfModel.getText(),Integer.parseInt(tfYear.getText()),Float.parseFloat(tfFuelAmount.getText()),Float.parseFloat(tfPrice.getText()));
                boolean status = advertManager.create(advert);
                if (status){
                    JOptionPane.showMessageDialog(null,"İlan Açma İşlemi Başarılı");
                    setVisible(false);
                    CreateAdvertForm createAdvertForm = new CreateAdvertForm(userId);
                }
            }
        });

        btnAdverts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                HomeForm homeForm = new HomeForm(userId);
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginForm loginForm = new LoginForm();
            }
        });

        btnMyAdverts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MyAdvertsForm myAdvertsForm = new MyAdvertsForm(userId);
            }
        });

        btnReservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ReservationsForm reservationsForm = new ReservationsForm(userId);
            }
        });

        btnMyReservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MyReservationsForm myReservationsForm = new MyReservationsForm(userId);
            }
        });

        btnCreateAdvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CreateAdvertForm createAdvertForm = new CreateAdvertForm(userId);
            }
        });
    }
}
