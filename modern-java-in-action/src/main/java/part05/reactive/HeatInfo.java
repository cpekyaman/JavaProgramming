package part05.reactive;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class HeatInfo {
    private final String location;
    private final int heat;
    private final LocalTime time;

    public HeatInfo(String location, int heat) {
        this(location, heat, LocalTime.now());
    }

    private HeatInfo(String location, int heat, LocalTime time) {
        this.location = location;
        this.heat = heat;
        this.time = time;
    }

    public HeatInfo toCelsius() {
        return new HeatInfo(this.location, (this.heat - 32) * 5 / 9, this.time);
    }

    @Override
    public String toString() {
        return String.format("Heat for %s is %d at %s", location, heat, time.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
}
