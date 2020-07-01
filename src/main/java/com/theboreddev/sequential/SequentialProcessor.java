package com.theboreddev.sequential;

import com.theboreddev.Processor;

import java.util.List;

public class SequentialProcessor implements Processor {

    @Override
    public Integer process(List<Integer> input) {
        return input
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
    }
}
