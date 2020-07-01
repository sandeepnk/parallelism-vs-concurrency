package com.theboreddev.benchmark;

import com.theboreddev.TestInputFactory;
import com.theboreddev.concurrency.ConcurrentProcessor;
import com.theboreddev.sequential.SequentialProcessor;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ConcurrentPerformanceTest {

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void test() throws InterruptedException {

        final ConcurrentProcessor processor = new ConcurrentProcessor();
        final IntStream intStream = TestInputFactory.randomIntStreamOfSize(1_000_000);

        final int result = processor.process(intStream.boxed().collect(toList()));

        assertThat(result).isGreaterThanOrEqualTo(1_000_000).isLessThanOrEqualTo(10_000_000);
    }
}
