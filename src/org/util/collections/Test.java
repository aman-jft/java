package org.util.collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        final ArrayList<ABC> abcs = new ArrayList<ABC>() {{

            add(new ABC(100, 200, "A1"));
            add(new ABC(100, 201, "A2"));
            add(new ABC(100, 201, "A3"));
            add(new ABC(101, 301, "B"));
            add(new ABC(102, 402, "C"));
            add(new ABC(103, 503, "D"));

        }};

        final Map<Integer, Map<Integer, Set<ABC>>> collect = abcs.stream()
                                                                 .collect(Collectors.groupingBy(abc -> abc.id1,
                                                                     Collectors.groupingBy(abc -> abc.id2,
                                                                         Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ABC::getName).reversed())))
        ));
        System.out.println(collect);
    }
}


class ABC {
    public Integer id1;
    public Integer id2;
    public String name;

    public Integer getId1() {
        return id1;
    }

    public Integer getId2() {
        return id2;
    }

    public String getName() {
        return name;
    }

    public ABC(Integer id1, Integer id2, String name) {
        this.id1 = id1;
        this.id2 = id2;
        this.name = name;
    }

    @Override public String toString() {
        return "ABC{" + "id1=" + id1 + ", id2=" + id2 + ", name='" + name + '\'' + '}';
    }
}
