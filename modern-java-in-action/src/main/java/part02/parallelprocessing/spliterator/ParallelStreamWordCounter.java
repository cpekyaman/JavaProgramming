package part02.parallelprocessing.spliterator;

import java.util.stream.IntStream;

public final class ParallelStreamWordCounter implements WordCounter {
    @Override
    public int count(String sentence) {
        return IntStream.range(0, sentence.length())
                .mapToObj(sentence::charAt)
                .parallel()
                .reduce(new WordCountTuple(0, true), WordCountTuple::accumulate, WordCountTuple::combine)
                .getCount();
    }
}
