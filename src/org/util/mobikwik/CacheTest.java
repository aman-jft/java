package org.util.mobikwik;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Optional;

public class CacheTest extends LinkedHashMap<String, String> {
    private static Integer MAX_SIZE = 100;
//    private LinkedHashMap cache = new LinkedHashMap();
    public Optional<String> get(String key){
        return Optional.ofNullable(this.getOrDefault(key, null));
    }
    public void delete(String key){
        this.delete(key);
    }
    public void set(String key, String value) {
        if(this.size()>=MAX_SIZE) {
            this.removeEldestEntry(new AbstractMap.SimpleEntry<String, String>(key, value));
        }
        this.put(key, value);
    }

    private void evict(String key) {

    }
}
