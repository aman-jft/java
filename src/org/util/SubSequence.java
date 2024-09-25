package org.util;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    //     [3, 10, 2, 1, 20]
    public static void main(String[] args) {
        int[] input = {3, 10, 2, 1, 20,1,2,3,4,40,5,6, 7, 50};
        List<List<Integer>> temp = new ArrayList<>();
        for (int i : input) {
            int max = 0;
            List preferred = new ArrayList();

            for (List<Integer> list : temp) {
                Integer last = list.get(list.size() - 1);
                if (last < i  && list.size()>preferred.size()) {
                    max = last;
                    preferred = list;
                }
            }
            System.out.println("Preferred"+ preferred);
            if (preferred.isEmpty()) {
                preferred.add(i);
                temp.add(preferred);
            } else {
                preferred.add(i);
            }
            System.out.println(temp);
        }
        System.out.println(temp);
    }
}
