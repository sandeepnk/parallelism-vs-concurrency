package com.theboreddev;

import com.theboreddev.concurrency.ConcurrentProcessor;
import com.theboreddev.parallelism.ParallelProcessor;
import com.theboreddev.sequential.SequentialProcessor;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CombinedTest {
    private final Processor sequential = new SequentialProcessor();
    private final Processor parallel = new ParallelProcessor();
    private final Processor concurrent = new ConcurrentProcessor();


    @Test
    public void shouldAddElementsForEachProcessorAndResultShouldMatch() throws InterruptedException {

        final IntStream intStream = TestInputFactory.randomIntStreamOfSize(1_000_000);
        final List<Integer> list = intStream.boxed().collect(toList());

        final int resultSequential = sequential.process(list);
        final int resultParallel = parallel.process(list);
        final int resultConcurrent = concurrent.process(list);

        assertThat(resultSequential).isEqualTo(resultParallel).isEqualTo(resultConcurrent);
    }
}
