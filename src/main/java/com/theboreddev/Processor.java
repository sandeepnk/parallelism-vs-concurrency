package com.theboreddev;

import java.util.List;

public interface Processor {
    Integer process(List<Integer> input) throws InterruptedException;
}
