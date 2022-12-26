package PresentationLayer;

import BusinessLogicLayer.AdvertManager;
import BusinessLogicLayer.ReservationManager;
import Entities.Advert;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private AdvertManager advertManager = new AdvertManager();
    private ReservationManager reservationManager = new ReservationManager();

    public HomeForm (int userId){
        setTitle("Anasayfa");
        setContentPane(HomePanel);
        setMinimumSize(new Dimension(1000,800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        List<Advert> adverts = advertManager.getOtherAdverts(userId);
        Object [][] data = new Object[adverts.size()][6];
        for (int i=0; i <= adverts.size()-1;i++){
            int j = 0;
            data[i][j]=adverts.get(i).getId();
            j++;
            data[i][j]=adverts.get(i).getBrand();
            j++;
            data[i][j]=adverts.get(i).getModel();
            j++;
            data[i][j]=adverts.get(i).getYear();
            j++;
            data[i][j]=adverts.get(i).getFuelAmount();
            j++;
            data[i][j]=adverts.get(i).getPrice();
        }
        jtAdverts.setModel(new DefaultTableModel(
                data,
                new String[]{"İlan Numarası","Marka","Model","Yıl","Yakıt(km)","Kiralama Ücreti"}
        ));
        setVisible(true);

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
        btnCreateReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean status = reservationManager.createReservation(Integer.parseInt(tfAdvertNo.getText()),userId,tfFirstDate.getText(),tfLastDate.getText());
                if (status){
                    JOptionPane.showMessageDialog(null,"Rezervasyon İşlemi Başarılı!");
                    setVisible(false);
                    HomeForm homeForm = new HomeForm(userId);
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
