package model;

public class Passenger extends Person {

    private int passengerID;
    private String nationality;
    private PassengerType passengerType;

    // Constructor dari database
    public Passenger(int passengerID, String name, String email,
                     String phone, String nationality,
                     PassengerType passengerType) {

        super(name, email, phone);

        this.passengerID = passengerID;
        this.nationality = nationality;
        this.passengerType = passengerType;
    }

    // Constructor untuk data baru
    public Passenger(String name, String email, String phone,
                     String nationality, PassengerType passengerType) {

        this(0, name, email, phone, nationality, passengerType);
    }

    @Override
    public String toString() {
        return name;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

}