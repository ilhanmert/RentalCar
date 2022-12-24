package Entities;

import java.util.Date;

public class Reservation {
    private int Id;
    private int AdvertId;
    private int CarOwnerId;
    private int CustomerId;
    private String FirstDate;
    private String LastDate;
    private boolean IsAccepted;

    public Reservation(int Id, int AdvertId, int CarOwnerId, int CustomerId, String FirstDate, String LastDate, boolean IsAccepted){
        this.setId(Id);
        this.setAdvertId(AdvertId);
        this.setCarOwnerId(CarOwnerId);
        this.setCustomerId(CustomerId);
        this.setFirstDate(FirstDate);
        this.setLastDate(LastDate);
        this.setIsAccepted(IsAccepted);
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAdvertId() {
        return AdvertId;
    }

    public void setAdvertId(int advertId) {
        AdvertId = advertId;
    }

    public int getCarOwnerId() {
        return CarOwnerId;
    }

    public void setCarOwnerId(int carOwnerId) {
        CarOwnerId = carOwnerId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getFirstDate() {
        return FirstDate;
    }

    public void setFirstDate(String firstDate) {
        FirstDate = firstDate;
    }

    public String getLastDate() {
        return LastDate;
    }

    public void setLastDate(String lastDate) {
        LastDate = lastDate;
    }

    public boolean isAccepted() {
        return IsAccepted;
    }

    public void setIsAccepted(boolean accepted) {
        IsAccepted = accepted;
    }
}
