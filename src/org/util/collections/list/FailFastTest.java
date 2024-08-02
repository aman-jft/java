package org.util.collections.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FailFastTest {
    public static void main(String[] args) {
        try {
            test_set();
        } catch (Exception ex) {
			ex.printStackTrace();
           // System.out.println(ex.printStackTrace());
        }
        try {
            test_list();
        } catch (Exception ex) {
			ex.printStackTrace();
            System.out.println("Exception thrown");
        }
        try {
            test_array_list();
        } catch (Exception ex) {
			ex.printStackTrace();
            System.out.println("Exception thrown");
        }
    }

    public static void test_set() {
        Set<String> set = new HashSet<>();
        set.add("Baeldung");
        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            set.add("Baeldung1");
            it.next();
        }
    }

    public static void test_list() {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {

            System.out.println(it.next());
            list.add("4");
        }
    }

    public static void test_array_list() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {

            System.out.println(it.next());
            list.add("4");
        }
    }
}
