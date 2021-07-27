package part05.reactive;

import io.reactivex.rxjava3.core.Observable;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RxJavaTest {
    @Test
    public void testFahrenheitHeat() {
        observeHeatFor("bedroom").blockingSubscribe(new HeatActuator("bedroom"));
    }

    @Test
    public void testCelsiusHeat() {
        observeHeatFor("bedroom").map(HeatInfo::toCelsius).blockingSubscribe(new HeatActuator("bedroom"));
    }

    @Test
    public void testMultipleHeatSensors() {
        Observable<HeatInfo> houseHeatSensors = Observable.merge(List.of("bedroom", "living room", "bathroom")
                .stream()
                .map(this::observeHeatFor).collect(Collectors.toList()));
        houseHeatSensors.blockingSubscribe(new HeatActuator("house"));
    }

    private Observable<HeatInfo> observeHeatFor(String location) {
        return Observable.create(emitter ->
                Observable.interval(1, TimeUnit.SECONDS)
                        .subscribe(i -> {
                            if(!emitter.isDisposed()) {
                                if(i >= 5) {
                                    emitter.onComplete();
                                } else {
                                    try {
                                        emitter.onNext(HeatSensor.measure(location));
                                    } catch (Exception e) {
                                        emitter.onError(e);
                                    }
                                }
                            }
                        }));
    }
}
