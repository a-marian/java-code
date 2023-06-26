package backtrack;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DoubleLinkedNode> cache;
    Map<Integer, DoubleLinkedList> frequency;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency=0;
        this.cache = new HashMap<>();
        this.frequency = new HashMap<>();
    }
    public int get(int key) {
        DoubleLinkedNode current = cache.get(key);
        if(current == null){
             return -1;
        }
        updateNode(current);
        return current.val;
    }

    public void put(int key, int value) {
        // corner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            DoubleLinkedNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequency.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequency.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequency.put(1, curList);
            cache.put(key, newNode);
        }
    }
    public void updateNode(DoubleLinkedNode current){
        int currFreq = current.frequency;
        DoubleLinkedList currList = frequency.get(currFreq);
        currList.removeNode(current);

        if(currFreq == minFrequency && currList.listSize == 0){
            minFrequency++;
        }
        current.frequency++;
        DoubleLinkedList newList = frequency.getOrDefault(current.frequency, new DoubleLinkedList());
        newList.addNode(current);
        frequency.put(current.frequency, newList);
    }

}

class DoubleLinkedNode {
    int key;
    int val;
    int frequency;
    DoubleLinkedNode prev;
    DoubleLinkedNode next;
    DoubleLinkedNode(int key, int val){
        this.key = key;
        this.val = val;
        this.frequency =1;
    }
}

class DoubleLinkedList{
    int listSize;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
     DoubleLinkedList(){
        this.listSize = 0;
        this.head = new DoubleLinkedNode(-1,-1);
        this.tail = new DoubleLinkedNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DoubleLinkedNode current){
         DoubleLinkedNode nextNode = head.next;
         current.next = nextNode;
         current.prev = head;
         head.next = current;
         nextNode.prev = current;
         listSize++;
    }

    public void removeNode(DoubleLinkedNode current){
         DoubleLinkedNode prevNode = current.prev;
         DoubleLinkedNode nextNode = current.next;
         prevNode.next = nextNode;
         nextNode.prev = prevNode;
         listSize--;
    }
}