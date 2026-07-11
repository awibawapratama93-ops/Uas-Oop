package model;

public enum PassengerType {

    DEWASA,
    ANAK_ANAK;

    @Override
    public String toString() {
        return this == DEWASA ? "Dewasa" : "Anak-anak";
    }

}