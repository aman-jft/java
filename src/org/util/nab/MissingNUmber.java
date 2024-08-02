package org.util.nab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNUmber {
    public static void main(String[] args) {
        run(1,2,3,5);
        run(-1, 1,2,3,4);

        run(-1, 6, 1,2,3,4);
    }

    public static void run(int... arr) {
        final int length = arr.length;

        final boolean[] booleans = new boolean[1000000];
        booleans[0]=true;
        for(int a:arr) {
            if (a>0) booleans[Math.abs(a)]=true;

        }
        final int i = IntStream.range(1, booleans.length)
                               .filter(value -> !booleans[value])
                               .findFirst()
                               .orElse(1);
        System.out.println(i);
    }
}
