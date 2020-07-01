package com.theboreddev.concurrency;

import com.theboreddev.Processor;
import com.theboreddev.TestInputFactory;
import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConcurrentProcessorTest {

    private final Processor processor = new ConcurrentProcessor();

    @Test
    public void shouldAddElementsInArray() throws InterruptedException {

        final IntStream intStream = TestInputFactory.randomIntStreamOfSize(1_000_000);

        final int result = processor.process(intStream.boxed().collect(toList()));

        System.out.println(result);

        assertThat(result).isGreaterThanOrEqualTo(1_000_000).isLessThanOrEqualTo(10_000_000);
    }
}
