package com.theboreddev.parallelism;

import com.theboreddev.Processor;
import com.theboreddev.TestInputFactory;
import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParallelProcessorTest {

    private final Processor processor = new ParallelProcessor();

    @Test
    public void shouldAddAllElementsInArray() throws InterruptedException {
        final IntStream intStream = TestInputFactory.randomIntStreamOfSize(1_000_000);

        final int result = processor.process(intStream.boxed().collect(toList()));

        assertThat(result).isGreaterThanOrEqualTo(1_000_000).isLessThanOrEqualTo(10_000_000);
    }

}
