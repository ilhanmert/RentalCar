package BusinessLogicLayer;

import DataAccessLayer.PostgreSQL.Database;
import Entities.Advert;

import java.util.ArrayList;
import java.util.List;

public class AdvertManager extends BaseManager {
    private Database database;
    public AdvertManager(){

    }

    @Override
    public Boolean create() {
        return null;
    }

    @Override
    public List<Advert> get() {
        List<Advert> advertList = new ArrayList<>();
        Advert advert = null;
        //while içerisinde her seferinde advert nesnesi oluşturup listeye at en son listeyi dön
        advertList.add(advert);
        database.getAdverts();
        return advertList;
    }

    @Override
    public Boolean delete() {
        return null;
    }
}
