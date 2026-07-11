package model;

public enum TicketStatus {

    PENDING,
    ACTIVE,
    CANCELLED,
    USED;

    @Override
    public String toString() {
        switch (this) {
            case PENDING:
                return "Pending";

            case ACTIVE:
                return "Active";

            case CANCELLED:
                return "Cancelled";

            case USED:
                return "Used";

            default:
                return name();
        }
    }

}