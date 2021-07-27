package part02.parallelprocessing.spliterator;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class SpliteratorTest {
    private String sentence;

     @Before
    public void setUp() {
        sentence = " Nel   mezzo del cammin  di nostra  vita "
                + "mi  ritrovai in una  selva oscura"
                + " ché la  dritta via era   smarrita ";
    }

    @Test
    public void testIterativeWordCount() {
         Assertions.assertThat(new IterativeWordCounter().count(sentence)).isEqualTo(19);
    }

    @Test
    public void testStreamWordCounter() {
         Assertions.assertThat(new StreamWordCounter().count(sentence)).isEqualTo(19);
    }

    @Test
    public void testParallelStreamWordCounter() {
        Assertions.assertThat(new ParallelStreamWordCounter().count(sentence)).isNotEqualTo(19);
    }

    @Test
    public void testCustomSpliteratorWordCounter() {
        Assertions.assertThat(new CustomSpliteratorWordCounter().count(sentence)).isEqualTo(19);
    }
}
