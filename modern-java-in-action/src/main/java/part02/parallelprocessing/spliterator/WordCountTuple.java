package part02.parallelprocessing.spliterator;

public final class WordCountTuple {
    private final int count;
    private final boolean lastCharIsSpace;

    public WordCountTuple(int count, boolean lastCharIsSpace) {
        this.count = count;
        this.lastCharIsSpace = lastCharIsSpace;
    }

    public WordCountTuple accumulate(Character ch) {
        if(Character.isWhitespace(ch)) {
            return lastCharIsSpace ? this : new WordCountTuple(count, true);
        } else {
            return lastCharIsSpace ? new WordCountTuple(count + 1, false) : this;
        }
    }

    public WordCountTuple combine(WordCountTuple other) {
        return new WordCountTuple(this.count + other.count, other.lastCharIsSpace);
    }

    public int getCount() {
        return count;
    }
}
