package org.util.cache;

public class LRUTest {
    public static void main(String[] args) {
        LRUCache<String, String> stringStringLRUCache = new LRUCache<>();
        stringStringLRUCache.put("1", "1");
        stringStringLRUCache.put("2", "2");
        stringStringLRUCache.put("3", "3");

        stringStringLRUCache.put("4", "4");
        stringStringLRUCache.get("2");
        stringStringLRUCache.put("5", "5");
        stringStringLRUCache.put("3", "3");
        stringStringLRUCache.put("6", "6");
        System.out.println("**************");
        stringStringLRUCache.printAll();
        stringStringLRUCache.put("1", "1");
        System.out.println("**************");
        stringStringLRUCache.printAll();
    }
}
