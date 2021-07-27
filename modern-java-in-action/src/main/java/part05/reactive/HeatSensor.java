package part05.reactive;

import java.util.Random;

public final class HeatSensor {
    private static final Random random = new Random();

    public static HeatInfo measure(String location) {
        return new HeatInfo(location, random.nextInt(100));
    }

    private HeatSensor() {
        //
    }
}
