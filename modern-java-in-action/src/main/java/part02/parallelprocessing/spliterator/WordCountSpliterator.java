package part02.parallelprocessing.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public final class WordCountSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar;

    public WordCountSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if(currentSize < 10) {
            return null;
        }
        for(int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
            if(Character.isWhitespace(string.charAt(splitPos))) {
                WordCountSpliterator si = new WordCountSpliterator(string.substring(currentChar, splitPos));
                currentChar = splitPos;
                return si;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
