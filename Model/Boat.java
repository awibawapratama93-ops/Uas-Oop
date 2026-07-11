package model;

public class Boat {

    private int boatID;
    private String boatName;
    private String boatType;
    private int capacity;

    // Constructor dari database
    public Boat(int boatID, String boatName, String boatType, int capacity) {
        this.boatID = boatID;
        this.boatName = boatName;
        this.boatType = boatType;
        this.capacity = capacity;
    }

    // Constructor untuk data baru
    public Boat(String boatName, String boatType, int capacity) {
        this(0, boatName, boatType, capacity);
    }

    @Override
    public String toString() {
        return boatName;
    }

    public int getBoatID() {
        return boatID;
    }

    public void setBoatID(int boatID) {
        this.boatID = boatID;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public String getBoatType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}