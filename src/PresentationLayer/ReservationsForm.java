package PresentationLayer;

import BusinessLogicLayer.ReservationManager;
import Entities.Reservation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReservationsForm extends JFrame {
    private JButton btnAdverts;
    private JButton btnMyAdverts;
    private JButton btnReservations;
    private JButton btnMyReservations;
    private JButton btnCreateAdvert;
    private JButton btnLogout;
    private JTable jtReservations;
    private JTextField tfReservationNo;
    private JButton btnAccept;
    private JButton btnDelete;
    private JPanel ReservationsPanel;
    private ReservationManager reservationManager = new ReservationManager();

    public ReservationsForm(int userId){
        setTitle("Rezervasyonlar");
        setContentPane(ReservationsPanel);
        setMinimumSize(new Dimension(1000,800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        List<Reservation> reservations = reservationManager.getIncomingReservations(userId);
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
        jtReservations.setModel(new DefaultTableModel(
                data,
                new String[]{"Rezervasyon Numarası","İlan Numarası","Teslim Alış Tarihi","Teslim Ediş Tarihi","İlan Durumu"}
        ));
        setVisible(true);
        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean status = reservationManager.changeReservationStatus(Integer.parseInt(tfReservationNo.getText()),"true");
                if (status){
                    JOptionPane.showMessageDialog(null,"Rezervasyon Onaylandı!");
                    setVisible(false);
                    ReservationsForm reservationsForm = new ReservationsForm(userId);
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean status = reservationManager.delete(Integer.parseInt(tfReservationNo.getText()));
                if (status){
                    JOptionPane.showMessageDialog(null,"Rezervasyon Silindi!");
                    setVisible(false);
                    ReservationsForm reservationsForm = new ReservationsForm(userId);
                }
            }
        });

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
