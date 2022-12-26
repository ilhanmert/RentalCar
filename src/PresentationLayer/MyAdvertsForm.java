package PresentationLayer;

import BusinessLogicLayer.AdvertManager;
import Entities.Advert;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MyAdvertsForm extends JFrame {
    private JTextField tfAdvertNo;
    private JButton btnDeleteAdvert;
    private JTable jtMyAdverts;
    private JButton btnLogout;
    private JButton btnCreateAdvert;
    private JButton btnMyReservations;
    private JButton btnReservations;
    private JButton btnMyAdverts;
    private JButton btnAdverts;
    private JPanel MyAdvertsPanel;
    private AdvertManager advertManager = new AdvertManager();

    public MyAdvertsForm(int userId){
        setTitle("İlanlarım");
        setContentPane(MyAdvertsPanel);
        setMinimumSize(new Dimension(1000,800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        List<Advert> adverts = advertManager.getAdvertsByUserId(userId);
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
        jtMyAdverts.setModel(new DefaultTableModel(
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
        btnDeleteAdvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean status = advertManager.delete(Integer.parseInt(tfAdvertNo.getText()));
                if (status){
                    JOptionPane.showMessageDialog(null,"İlan Silme İşlemi Başarılı!");
                    setVisible(false);
                    MyAdvertsForm myAdvertsForm = new MyAdvertsForm(userId);
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
