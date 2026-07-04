package model;

public class Ticket {
    private int ticketID;
    private int passengerID;
    private int scheduleID;
    private String ticketCode;
    private String tripType;
    private double totalPrice;
    private double paidAmount;
    private double changeAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String ticketStatus;
    private Passenger passenger;
    private Schedule schedule;

    // Constructor dari database
    public Ticket(int ticketID, int passengerID, int scheduleID, String ticketCode,
                  String tripType, double totalPrice, double paidAmount, double changeAmount,
                  String paymentMethod, String paymentStatus, String ticketStatus) {
        this.ticketID = ticketID;
        this.passengerID = passengerID;
        this.scheduleID = scheduleID;
        this.ticketCode = ticketCode;
        this.tripType = tripType;
        this.totalPrice = totalPrice;
        this.paidAmount = paidAmount;
        this.changeAmount = changeAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.ticketStatus = ticketStatus;
    }

    // Constructor manual (input baru)
    public Ticket(int passengerID, int scheduleID, String ticketCode, String tripType,
                  double totalPrice, double paidAmount, double changeAmount,
                  String paymentMethod, String paymentStatus, String ticketStatus) {
        this(0, passengerID, scheduleID, ticketCode, tripType, totalPrice,
             paidAmount, changeAmount, paymentMethod, paymentStatus, ticketStatus);
    }

    // getter & setter
    public int getTicketID() { return ticketID; }
    public void setTicketID(int ticketID) { this.ticketID = ticketID; }
    public int getPassengerID() { return passengerID; }
    public void setPassengerID(int passengerID) { this.passengerID = passengerID; }
    public int getScheduleID() { return scheduleID; }
    public void setScheduleID(int scheduleID) { this.scheduleID = scheduleID; }
    public String getTicketCode() { return ticketCode; }
    public void setTicketCode(String ticketCode) { this.ticketCode = ticketCode; }
    public String getTripType() { return tripType; }
    public void setTripType(String tripType) { this.tripType = tripType; }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public double getPaidAmount() { return paidAmount; }
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }
    public double getChangeAmount() { return changeAmount; }
    public void setChangeAmount(double changeAmount) { this.changeAmount = changeAmount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public String getTicketStatus() { return ticketStatus; }
    public void setTicketStatus(String ticketStatus) { this.ticketStatus = ticketStatus; }
    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public Schedule getSchedule() { return schedule; }
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
}