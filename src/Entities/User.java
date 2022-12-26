package Entities;

public class User {
    private int Id;
    private String Name;
    private String Surname;
    private String Mail;
    private String Password;
    private String PhoneNumber;
    private String UserType;

    public User (){

    }

    public User(int Id, String Name, String Surname, String Mail, String Password, String PhoneNumber, String UserType){
        this.setId(Id);
        this.setName(Name);
        this.setSurname(Surname);
        this.setMail(Mail);
        this.setPassword(Password);
        this.setPhoneNumber(PhoneNumber);
        this.setUserType(UserType);
    }

    public User(String Name, String Surname, String Mail, String Password, String PhoneNumber){
        this.setName(Name);
        this.setSurname(Surname);
        this.setMail(Mail);
        this.setPassword(Password);
        this.setPhoneNumber(PhoneNumber);
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }
}
