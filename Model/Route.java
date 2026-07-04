package model;

public class Route {
    private int routeID;
    private String origin;
    private String destination;
    private double priceAdult;
    private double priceChild;

    // Constructor dari database
    public Route(int routeID, String origin, String destination, double priceAdult, double priceChild) {
        this.routeID = routeID;
        this.origin = origin;
        this.destination = destination;
        this.priceAdult = priceAdult;
        this.priceChild = priceChild;
    }

    // Constructor manual (input baru)
    public Route(String origin, String destination, double priceAdult, double priceChild) {
        this(0, origin, destination, priceAdult, priceChild);
    }

    @Override
    public String toString() {
        return this.origin + " → " + this.destination;
    }

    // getter & setter
    public int getRouteID() { return routeID; }
    public void setRouteID(int routeID) { this.routeID = routeID; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public double getPriceAdult() { return priceAdult; }
    public void setPriceAdult(double priceAdult) { this.priceAdult = priceAdult; }
    public double getPriceChild() { return priceChild; }
    public void setPriceChild(double priceChild) { this.priceChild = priceChild; }
}