package model;

public class Ticket {

    private int ticketID;
    private int passengerID;
    private int scheduleID;
    private String ticketCode;
    private TripType tripType;
    private double totalPrice;
    private double paidAmount;
    private double changeAmount;
    private String paymentMethod;
    private PaymentStatus paymentStatus;
    private TicketStatus ticketStatus;

    // Relasi object (tidak disimpan di database)
    private Passenger passenger;
    private Schedule schedule;

    // Constructor dari database
    public Ticket(int ticketID, int passengerID, int scheduleID,
                  String ticketCode, TripType tripType,
                  double totalPrice, double paidAmount,
                  double changeAmount, String paymentMethod,
                  PaymentStatus paymentStatus, TicketStatus ticketStatus) {

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

    // Constructor untuk data baru
    public Ticket(int passengerID, int scheduleID,
                  String ticketCode, TripType tripType,
                  double totalPrice, double paidAmount,
                  double changeAmount, String paymentMethod,
                  PaymentStatus paymentStatus, TicketStatus ticketStatus) {

        this(0, passengerID, scheduleID, ticketCode, tripType,
             totalPrice, paidAmount, changeAmount,
             paymentMethod, paymentStatus, ticketStatus);
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(double changeAmount) {
        this.changeAmount = changeAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}