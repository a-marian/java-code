package backtrack;

import java.util.LinkedList;
import java.util.Map;

public class HashTableImpl {

    private LinkedList<Entry>[] table;
    private int capacity;

    public HashTableImpl(int capacity){
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for(int i=0; i<capacity; i++){
            table[i]= new LinkedList<>();
        }
    }
    private void put(String key, Integer value) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        for(Entry entry: bucket){
            if(entry.key.equals(key)){
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }
    private void get(String key){
     int index = hash(key);
     LinkedList<Entry> bucket = table[index];
     for(Entry entry : bucket){
         if(entry.key.equals(key)){

         }
     }
    }

    public void remove(String key){
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        for(Entry entry: bucket){
            if(entry.key.equals(key)){
                bucket.remove(key);
                return;
            }
        }
    }

    private int hash(String key){
        return Math.abs(key.hashCode()%capacity);
    }
}


class Entry {
     String key;
     Integer value;

    public Entry(String key, Integer value){
        this.key = key;
        this.value = value;
    }
}

