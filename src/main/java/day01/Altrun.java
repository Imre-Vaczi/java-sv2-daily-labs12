package day01;

import java.time.LocalDate;

public class Altrun {

    private double distance;
    private LocalDate date;

    public Altrun(double distance, LocalDate date) {
        this.distance = distance;
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Altrun{" +
                "distance=" + distance +
                ", date=" + date +
                '}';
    }
}
