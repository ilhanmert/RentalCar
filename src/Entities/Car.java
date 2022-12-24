package Entities;

public class Car {
    private int Id;
    private int AdvertId;
    private int UserId;
    private String Brand;
    private String Model;
    private int Year;
    private float FuelAmount;

    public Car(int Id, int AdvertId, int UserId, String Brand, String Model, int Year, float FuelAmount){
        this.setId(Id);
        this.setAdvertId(AdvertId);
        this.setUserId(UserId);
        this.setBrand(Brand);
        this.setModel(Model);
        this.setYear(Year);
        this.setFuelAmount(FuelAmount);
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

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public float getFuelAmount() {
        return FuelAmount;
    }

    public void setFuelAmount(float fuelAmount) {
        FuelAmount = fuelAmount;
    }
}
