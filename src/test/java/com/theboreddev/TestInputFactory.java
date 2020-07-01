package com.theboreddev;

import java.util.Random;
import java.util.stream.IntStream;

public class TestInputFactory {
    private static final Random RANDOM = new Random();

    public static IntStream randomIntStreamOfSize(int size) {
        return IntStream.generate(TestInputFactory::randomInt)
                .limit(size);
    }

    private static int randomInt() {
        return RANDOM.nextInt(10 - 1 + 1) + 1;
    }

    public static void main(String[] args) {
        final IntStream intStream = randomIntStreamOfSize(10000000);
        intStream.forEach(System.out::println);
    }
}
