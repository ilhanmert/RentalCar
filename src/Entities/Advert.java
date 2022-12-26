package Entities;

public class Advert {
    private int Id;
    private int UserId;
    private String Brand;
    private String Model;
    private int Year;
    private float FuelAmount;
    private float Price;

    public Advert(int Id, int UserId, String Brand, String Model, int Year, float FuelAmount, float Price){
        this.setId(Id);
        this.setUserId(UserId);
        this.setBrand(Brand);
        this.setModel(Model);
        this.setYear(Year);
        this.setFuelAmount(FuelAmount);
        this.setPrice(Price);
    }

    public Advert(int UserId,String Brand, String Model, int Year, float FuelAmount, float Price){
        this.setUserId(UserId);
        this.setBrand(Brand);
        this.setModel(Model);
        this.setYear(Year);
        this.setFuelAmount(FuelAmount);
        this.setPrice(Price);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
