package part02.parallelprocessing.spliterator;

import java.util.stream.StreamSupport;

public final class CustomSpliteratorWordCounter implements WordCounter {
    @Override
    public int count(String sentence) {
        WordCountSpliterator si = new WordCountSpliterator(sentence);
        return StreamSupport.stream(si, true)
                .reduce(new WordCountTuple(0, true), WordCountTuple::accumulate, WordCountTuple::combine)
                .getCount();
    }
}
