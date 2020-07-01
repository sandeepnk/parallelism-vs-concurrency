package com.theboreddev.parallelism;

import com.theboreddev.Processor;

import java.util.List;

public class ParallelProcessor implements Processor {

    @Override
    public Integer process(List<Integer> input) {
        return input
                .parallelStream()
                .reduce(Integer::sum)
                .orElse(0);
    }
}
