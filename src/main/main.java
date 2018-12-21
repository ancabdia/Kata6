package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import model.*;

public class main {
     public static void main(String[] args) {
        List<File> list = new ArrayList<>();
        fill(new File("C:\\pub"),list);
        Histogram<Integer> histogram = new Histogram(megabytes(length(list)));
        Set<Integer> set = histogram.lista();
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
    
    private static Iterator<Long> length(List<File> list) {
        return new Iterator<Long>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < list.size();
            }
             @Override
            public Long next() {
                return list.get(index++).length();
            }
        };
    }
    
    private static Iterator<Integer> megabytes(Iterator<Long> iterator) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }
             @Override
            public Integer next() {
                return (int)(iterator.next() / (1024*1024));
            }
        };
    }
     private static void fill(File parent, List<File> list) {
        for (File file : notNull(parent.listFiles())) 
            if (file.isDirectory())
                fill(file,list);
            else
                list.add(file);
    }
     private static File[] notNull(File[] list) {
        return list != null ? list : new File[0];
    }
}
