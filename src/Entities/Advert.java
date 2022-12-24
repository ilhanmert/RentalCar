package Entities;

public class Advert {
    private int Id;
    private int UserId;
    private int CarId;
    private String PhotoPath;
    private float Price;

    public Advert(int Id, int UserId, int CarId, String PhotoPath, float Price){
        this.setId(Id);
        this.setUserId(UserId);
        this.setCarId(CarId);
        this.setPhotoPath(PhotoPath);
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

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int carId) {
        CarId = carId;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public void setPhotoPath(String photoPath) {
        PhotoPath = photoPath;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
