package BusinessLogicLayer;

import DataAccessLayer.PostgreSQL.Database;
import Entities.Advert;
import Entities.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationManager extends BaseManager {
    Database database = new Database();
    public ReservationManager(){
        database.connect();
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public Boolean delete(int reservationId) {
        database.deleteReservation(reservationId);
        return true;
    }

    public Boolean createReservation(int advertId, int userId, String firstDate, String lastDate) {
        database.createReservation(advertId,userId,firstDate,lastDate);
        return true;
    }

    public List<Reservation> getReservations(int userId){
        List<Reservation> reservations = new ArrayList<>();
        ResultSet resultSet = database.getReservations(userId);
        try {
            while (resultSet.next()) {
                int reservationId = (Integer.parseInt(resultSet.getString("id")));
                int advertId = (Integer.parseInt(resultSet.getString("advertid")));
                int carownerid = (Integer.parseInt(resultSet.getString("carownerid")));
                int customerid = (Integer.parseInt(resultSet.getString("customerid")));
                String firstDate = resultSet.getString("firstdate");
                String lastDate = resultSet.getString("lastdate");
                String isAccepted = resultSet.getString("isaccepted");
                if (isAccepted == null){
                    isAccepted = "Bekliyor";
                } else  {
                    isAccepted = "Onaylandı";
                }
                Reservation reservation = new Reservation(reservationId,advertId,carownerid,customerid,firstDate,lastDate,isAccepted);
                reservations.add(reservation);
            }
            return reservations;
        }
        catch (SQLException ex){
            throw new RuntimeException();
        }
    }

    public List<Reservation> getIncomingReservations(int userId){
        List<Reservation> reservations = new ArrayList<>();
        ResultSet resultSet = database.getIncomingReservations(userId);
        try {
            while (resultSet.next()) {
                int reservationId = (Integer.parseInt(resultSet.getString("id")));
                int advertId = (Integer.parseInt(resultSet.getString("advertid")));
                int carownerid = (Integer.parseInt(resultSet.getString("carownerid")));
                int customerid = (Integer.parseInt(resultSet.getString("customerid")));
                String firstDate = resultSet.getString("firstdate");
                String lastDate = resultSet.getString("lastdate");
                String isAccepted = resultSet.getString("isaccepted");
                if (isAccepted == null){
                    isAccepted = "Bekliyor";
                } else  {
                    isAccepted = "Onaylandı";
                }
                Reservation reservation = new Reservation(reservationId,advertId,carownerid,customerid,firstDate,lastDate,isAccepted);
                reservations.add(reservation);
            }
            return reservations;
        }
        catch (SQLException ex){
            throw new RuntimeException();
        }
    }

    public boolean changeReservationStatus(int reservationId, String status){
        database.changeReservationStatus(reservationId,status);
        return true;
    }
}
