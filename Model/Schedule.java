package model;

public class Schedule {
    private int scheduleID;
    private int boatID;
    private int routeID;
    private String departureDate;
    private String departureTime;
    private int availableSeats;
    private Boat boat;
    private Route route;

    // Constructor dari database
    public Schedule(int scheduleID, int boatID, int routeID, String departureDate, String departureTime, int availableSeats) {
        this.scheduleID = scheduleID;
        this.boatID = boatID;
        this.routeID = routeID;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    // Constructor manual (input baru)
    public Schedule(int boatID, int routeID, String departureDate, String departureTime, int availableSeats) {
        this(0, boatID, routeID, departureDate, departureTime, availableSeats);
    }

    @Override
    public String toString() {
        return departureDate + " " + departureTime;
    }

    // getter & setter
    public int getScheduleID() { return scheduleID; }
    public void setScheduleID(int scheduleID) { this.scheduleID = scheduleID; }
    public int getBoatID() { return boatID; }
    public void setBoatID(int boatID) { this.boatID = boatID; }
    public int getRouteID() { return routeID; }
    public void setRouteID(int routeID) { this.routeID = routeID; }
    public String getDepartureDate() { return departureDate; }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
    public Boat getBoat() { return boat; }
    public void setBoat(Boat boat) { this.boat = boat; }
    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }
}