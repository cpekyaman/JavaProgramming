package part02.parallelprocessing.spliterator;

public final class IterativeWordCounter implements WordCounter {
    @Override
    public int count(String sentence) {
        int count = 0;
        boolean lastCharIsSpace = false;
        for(int i = 0; i< sentence.length(); i++) {
            if(Character.isWhitespace(sentence.charAt(i))) {
                lastCharIsSpace = true;
            } else {
                if(lastCharIsSpace) {
                    count += 1;
                }
                lastCharIsSpace = false;
            }
        }
        return count;
    }
}
