package DataAccessLayer.PostgreSQL;

import java.sql.*;

public class Database {
    private final String url = "jdbc:postgresql://localhost/rentalcarjava";
    private final String user = "postgres";
    private final String password = "m";
    Connection conn = null;
    public  Connection connect() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /*Bütün kullanıcıları databaseden çeken fonksiyon*/
    public ResultSet getUsers(){
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.getusers()");
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Mail ve şifreyi databaseden kontrol eden fonksiyon
    * mail -> kullanıcı maili / password -> kullanıcı şifresi*/
    public ResultSet checkUser(String mail, String password){
        String sql = "SELECT * FROM public.checkuser('"+mail+"','"+password+"')";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Database'e kullanıcı kaydını yapmaya yarayan fonksiyon - name -> kullanıcının adı
    * surname -> kullanıcının soyadı / mail -> kullanıcının maili
    * password -> kullanıcının şifrelenmiş şifresi / phoneNumber -> kullanıcının telefon numarası*/
    public ResultSet createUser(String name, String surname, String mail, String password, String phoneNumber){
        String sql = "SELECT * FROM public.createuser('"+name+"','"+surname+"','"+mail+"','"+password+"','"+phoneNumber+"',' '";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Kullanıcıyı databaseden silmeye yarayan fonksiyon - userId -> adminin silmek için seçtiği kullanıcının ID*/
    public ResultSet deleteUser(int userId){
        String sql = "SELECT * FROM public.deleteuser("+userId+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Bütün ilanları databaseden çeken fonksiyon*/
    public ResultSet getAdverts(){
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.getadverts()");
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Kullanıcıya ait ilanları databaseden çeken fonksiyon - userId -> işlemi yapan kullanıcının ID*/
    public ResultSet getAdvertsByUserId(int userId){
        String sql = "SELECT * FROM public.getadverts("+userId+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Kullanıcının kendi ilanları hariç bütün ilanları databaseden çeken fonksiyon - userId -> işlemi yapan kullanıcının ID*/
    public ResultSet getOtherAdverts(int userId){
        String sql = "SELECT * FROM public.getotheradverts("+userId+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*İlan bilgilerini databasede güncellemeye yarayan fonksiyon
    * advertId -> ilan ID / brand -> ilandaki arabanın markası / model -> ilandaki arabanın modeli
    * year -> ilandaki arabanın üretim yılı / fuelAmount -> ilandaki arabanın km başına yaktığı yakıt miktarı
    * photoPath -> ilandaki arabanın fotoğrafının yolu / price -> ilanın ücreti  */
    public ResultSet updateAdvert(int advertId, String brand, String model, int year, float fuelAmount, String photoPath, float price){
        String sql = "SELECT * FROM public.updateadvert("+advertId+",'"+brand+"','"+model+"',"+year+","+fuelAmount+",'"+photoPath+"',"+price+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*İlanın database'e kaydedilmesini sağlayan fonksiyon
    * id -> ilanı oluşturan kullanıcının ID / bran -> ilana girilen aracın markası
    * model -> ilana girilen aracın modeli / year -> ilana girilen aracın yılı
    * fuelAmount -> ilana girilen aracın km başına yakıt miktarı / photoPath -> ilana girilen aracın fotoğrafının yolu
    * price -> ilanın ücreti*/
    public ResultSet createAdvert(int userId, String brand, String model, int year, float fuelAmount, String photoPath, float price){
        String sql = "SELECT * FROM public.createadvert("+userId+",'"+brand+"','"+model+"',"+year+","+fuelAmount+",'"+photoPath+"',"+price+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*İlanı databaseden silmeye yarayan fonksiyon - advertId -> silinmesi için seçilen ilanın ID*/
    public ResultSet deleteAdvert(int advertId){
        String sql = "SELECT * FROM public.deleteadvert("+advertId+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Kullanıcının yaptığı rezervasyonları databaseden çeken fonksiyon - userId -> işlemi yapan kullanıcının ID*/
    public ResultSet getReservations(int userId){
        String sql = "SELECT * FROM public.getreservations("+userId+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Yapılan rezervasyonu database'e kaydeden fonksiyon
    * advertId -> rezervasyon yapılan ilanın ID / userId -> rezervasyon yapan kullanıcının ID
    * firstDate -> aracın teslim alınacağı tarih / lastDate -> aracın teslim edileceği tarih*/
    public ResultSet createReservation(int advertId, int userId, String firstDate, String lastDate){
        String sql = "SELECT * FROM public.createreservation("+advertId+","+userId+",'"+firstDate+"','"+lastDate+"')";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Yapılan rezervasyonu databaseden silmeye yarayan fonksiyon - reservationId -> seçilen rezervasyonun ID*/
    public ResultSet deleteReservation(int reservationId){
        String sql = "SELECT * FROM public.deletereservation("+reservationId+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Kullanıcının ilanlarına gelen rezervasyon isteklerini databaseden çeken fonksiyon - userId -> işlemi yapan kullanıcının ID*/
    public ResultSet getIncomingReservations(int userId){
        String sql = "SELECT * FROM public.getincomingreservations("+userId+")";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*Rezervasyonun durumunu database'de değiştiren fonksiyon - reservationId -> seçilen rezervasyonun ID
    * status -> rezervasyonun onaylanmasını(true) ya da reddedilmesini(false) belirtir*/
    public ResultSet changeReservationStatus(int reservationId, String status){
        String sql = "SELECT * FROM public.changereservationstatus("+reservationId+",'"+status+"')";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
