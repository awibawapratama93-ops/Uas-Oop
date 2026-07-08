package model;

public enum PaymentStatus {
    PENDING, PAID, CANCELLED;

    @Override
    public String toString() {
        switch (this) {
            case PENDING: return "Pending";
            case PAID: return "Paid";
            case CANCELLED: return "Cancelled";
            default: return name();
        }
    }
}