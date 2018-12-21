package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {
    private Map<T,Integer> map = new HashMap<>();
    
    public Histogram(Iterator<T> iterator) {
        this(iterableOf(iterator));
    }
    
    public Histogram(Iterable<T> iterable) {
        for (T item : iterable) {
            add(item);
        }
    }
    
    private static <T> Iterable<T> iterableOf(Iterator<T> iterator) {
        
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }
        };
    }
     public Set<T> lista() {
        return map.keySet();
    }
     private void add(T item) {
        map.put(item, sum(item));
    }
     private Integer sum(T item) {
        return map.containsKey(item) ? map.get(item)+1 : 0;
    }
}