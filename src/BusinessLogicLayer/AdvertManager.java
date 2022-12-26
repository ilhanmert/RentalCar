package BusinessLogicLayer;

import DataAccessLayer.PostgreSQL.Database;
import Entities.Advert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvertManager extends BaseManager {
    private Database database = new Database();
    public AdvertManager(){
        database.connect();
    }

    @Override
    public List<Advert> get() {
        List<Advert> adverts = new ArrayList<>();
        ResultSet resultSet = database.getAdverts();
        try {
            while (resultSet.next()) {
                int advertId = (Integer.parseInt(resultSet.getString("advertid")));
                int userId = (Integer.parseInt(resultSet.getString("userid")));
                String brand = (resultSet.getString("brand"));
                String model = (resultSet.getString("model"));
                int year = Integer.parseInt(resultSet.getString("year"));
                float price = Float.parseFloat(resultSet.getString("price"));
                float fuelAmount = Float.parseFloat(resultSet.getString("fuelamount"));
                Advert advert = new Advert(advertId,userId,brand,model,year,fuelAmount,price);
                adverts.add(advert);
            }
            return adverts;
        }
        catch (SQLException ex){
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean delete(int advertId) {
        database.deleteAdvert(advertId);
        return true;
    }

    public Boolean create(Advert advert) {
        database.createAdvert(advert.getUserId(),advert.getBrand(),advert.getModel(),advert.getYear(),advert.getFuelAmount(), advert.getPrice());
        return true;
    }

    public List<Advert> getOtherAdverts(int userid){
        List<Advert> adverts = new ArrayList<>();
        ResultSet resultSet = database.getOtherAdverts(userid);
        try {
            while (resultSet.next()) {
                int advertId = (Integer.parseInt(resultSet.getString("id")));
                int userId = (Integer.parseInt(resultSet.getString("userid")));
                String brand = (resultSet.getString("brand"));
                String model = (resultSet.getString("model"));
                int year = Integer.parseInt(resultSet.getString("year"));
                float price = Float.parseFloat(resultSet.getString("price"));
                float fuelAmount = Float.parseFloat(resultSet.getString("fuelamount"));
                Advert advert = new Advert(advertId,userId,brand,model,year,fuelAmount,price);
                adverts.add(advert);
            }
            return adverts;
        }
        catch (SQLException ex){
            throw new RuntimeException();
        }
    }

    public List<Advert> getAdvertsByUserId(int userid){
        List<Advert> adverts = new ArrayList<>();
        ResultSet resultSet = database.getAdvertsByUserId(userid);
        try {
            while (resultSet.next()) {
                int advertId = (Integer.parseInt(resultSet.getString("id")));
                int userId = (Integer.parseInt(resultSet.getString("userid")));
                String brand = (resultSet.getString("brand"));
                String model = (resultSet.getString("model"));
                int year = Integer.parseInt(resultSet.getString("year"));
                float price = Float.parseFloat(resultSet.getString("price"));
                float fuelAmount = Float.parseFloat(resultSet.getString("fuelamount"));
                Advert advert = new Advert(advertId,userId,brand,model,year,fuelAmount,price);
                adverts.add(advert);
            }
            return adverts;
        }
        catch (SQLException ex){
            throw new RuntimeException();
        }
    }
}
