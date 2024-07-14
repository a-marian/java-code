package backtrack;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/description/
 * */
public class LRUCache {

    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;
    Map<Integer, DoubleLinkedListNode> map;
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoubleLinkedListNode(-1,-1);
        tail = new DoubleLinkedListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedListNode node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
       if(map.containsKey(key)){
           remove(map.get(key));
       }
       if(map.size() == capacity){
           remove(tail.prev);
       }
       add(new DoubleLinkedListNode(key, value));
    }

    private void add(DoubleLinkedListNode node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(DoubleLinkedListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

}
class DoubleLinkedListNode {
    int key;
    int val;
    DoubleLinkedListNode next;
    DoubleLinkedListNode prev;
    DoubleLinkedListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}
