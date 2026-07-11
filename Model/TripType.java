package model;

public enum TripType {

    SATU_ARAH,
    PERGI_PULANG;

    @Override
    public String toString() {
        return this == SATU_ARAH ? "Satu Arah" : "Pergi Pulang";
    }

}