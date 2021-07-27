package part05.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public final class HeatActuator implements Observer<HeatInfo> {
    private final String location;

    public HeatActuator(String location) {
        this.location = location;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        //
    }

    @Override
    public void onNext(@NonNull HeatInfo heatInfo) {
        System.out.println(heatInfo);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        System.out.println("Error in heat measurement : " + e.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Done!");
    }
}
