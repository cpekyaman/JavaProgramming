package part02.parallelprocessing;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms1g", "-Xmx2g"})
@State(Scope.Benchmark)
public class ParallelStreamBenchmark {
    private static final long N = 100_000L;

    @Benchmark
    public long sequentialStreamSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N).reduce(0L, Long::sum);
    }

    @Benchmark
    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    @Benchmark
    public long longRangeSum() {
        return LongStream.rangeClosed(1, N).reduce(0L, Long::sum);
    }

    @Benchmark
    public long longRangeParallelSum() {
        return LongStream.rangeClosed(1, N).parallel().reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}
