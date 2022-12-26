package PresentationLayer;

import BusinessLogicLayer.ReservationManager;
import Entities.Reservation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MyReservationsForm extends JFrame{
    private JButton btnLogout;
    private JButton btnAdverts;
    private JButton btnMyAdverts;
    private JButton btnCreateAdvert;
    private JButton btnMyReservations;
    private JButton btnReservations;
    private JTable jtMyReservations;
    private JPanel MyReservationsPanel;
    private ReservationManager reservationManager = new ReservationManager();

    public MyReservationsForm(int userId){
        setTitle("Rezervasyonlar");
        setContentPane(MyReservationsPanel);
        setMinimumSize(new Dimension(1000,800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        List<Reservation> reservations = reservationManager.getReservations(userId);
        Object [][] data = new Object[reservations.size()][6];
        for (int i=0; i <= reservations.size()-1;i++){
            int j = 0;
            data[i][j]=reservations.get(i).getId();
            j++;
            data[i][j]=reservations.get(i).getAdvertId();
            j++;
            data[i][j]=reservations.get(i).getFirstDate();
            j++;
            data[i][j]=reservations.get(i).getLastDate();
            j++;
            data[i][j]=reservations.get(i).getIsAccepted();
        }
        jtMyReservations.setModel(new DefaultTableModel(
                data,
                new String[]{"Rezervasyon Numarası","İlan Numarası","Teslim Alış Tarihi","Teslim Ediş Tarihi","İlan Durumu"}
        ));
        setVisible(true);

        btnMyAdverts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MyAdvertsForm myAdvertsForm = new MyAdvertsForm(userId);
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginForm loginForm = new LoginForm();
            }
        });

        btnAdverts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                HomeForm homeForm = new HomeForm(userId);
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
