package model;

public class Passenger extends Person {
    private int passengerID;
    private String nationality;
    private String passengerType;

    // Constructor dari database
    public Passenger(int passengerID, String name, String email, String phone, String nationality, String passengerType) {
        super(name, email, phone);
        this.passengerID = passengerID;
        this.nationality = nationality;
        this.passengerType = passengerType;
    }

    // Constructor manual (input baru)
    public Passenger(String name, String email, String phone, String nationality, String passengerType) {
        this(0, name, email, phone, nationality, passengerType);
    }

    @Override
    public String toString() {
        return this.name;
    }

    // getter & setter
    public int getPassengerID() { return passengerID; }
    public void setPassengerID(int passengerID) { this.passengerID = passengerID; }
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public String getPassengerType() { return passengerType; }
    public void setPassengerType(String passengerType) { this.passengerType = passengerType; }
}