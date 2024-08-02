package org.util.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity = 5;
    private final LinkedHashMap<K, V> cache= new LinkedHashMap<K,V>(capacity, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    };

    public void printAll() {
        cache.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
//        if (cache.size() > capacity) {
//            removeLRUEntry();
//        }
    }

//    private void removeLRUEntry() {
//        Map.Entry<K, V> eldestEntry = null;
//
//        for (Map.Entry<K, V> entry : cache.entrySet()) {
//            eldestEntry = entry  ;
//            break; // Iterate only once to get the eldest entry
//        }
//
//        if (eldestEntry != null) {
//            K eldestKey = eldestEntry.getKey();
//            cache.remove(eldestKey);
//        }
//    }

}
