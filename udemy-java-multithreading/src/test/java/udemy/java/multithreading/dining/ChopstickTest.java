package udemy.java.multithreading.dining;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChopstickTest extends Assertions {
    private Chopstick chopstick;

    @Before
    public void setup() {
        chopstick = new Chopstick(new Random().nextInt(1000));
    }

    @Test
    public void whenPickUpIsTriedBeforeAnyOneThenItShouldSucceed() {
        assertThat(chopstick.pickUp()).isTrue();
    }

    @Test
    public void whenPickUpIsTriedMultipleTimeInTheSameThreadThenItShouldSucceed() {
        assertThat(chopstick.pickUp()).isTrue();
        assertThat(chopstick.pickUp()).isTrue();
    }

    @Test
    public void whenPutDownIsTriedAndWeAreTheHolderOfChopstickThenItShouldSucceed() {
        // given
        assertThat(chopstick.pickUp()).isTrue();

        // when / then
        assertThat(chopstick.putDown()).isTrue();
    }

    @Test
    public void whenPickUpIsTriedAndItIsAlreadyPickedUpThenItShouldFail() throws InterruptedException {
        // given
        AtomicBoolean acquired = new AtomicBoolean(false);
        CountDownLatch done = new CountDownLatch(2);

        Thread chopstickHolder = chopstickHolderThread(done);

        Thread chopstickRequester = new Thread(() -> {
            acquired.set(chopstick.pickUp());
            done.countDown();
        });

        // when
        chopstickHolder.start();
        chopstickRequester.start();
        done.await();

        // then
        assertThat(acquired.get()).isFalse();
    }

    @Test
    public void whenPutDownTriedAndWeAreNotHolderThenItShouldFail() throws InterruptedException {
        // given
        AtomicBoolean putDown = new AtomicBoolean(false);
        CountDownLatch done = new CountDownLatch(2);

        Thread chopstickHolder = chopstickHolderThread(done);

        Thread chopstickRequester = new Thread(() -> {
            putDown.set(chopstick.putDown());
            done.countDown();
        });

        // when
        chopstickHolder.start();
        chopstickRequester.start();
        done.await();

        // then
        assertThat(putDown.get()).isFalse();
    }

    private Thread chopstickHolderThread(CountDownLatch done) {
        return new Thread(() -> {
            chopstick.pickUp();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            done.countDown();
        });
    }
}
