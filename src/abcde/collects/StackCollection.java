package abcde.collects;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

public class StackCollection {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(11);
        stack.add(12);
        stack.add(13);
        stack.add(14);
        stack.add(15);
        stack.peek(); // 15
        stack.pop(); // remove 15
        System.out.println( stack.empty()); // false
        System.out.println(stack); // [10, 11, 12, 13, 14]

        Vector<Integer> vector = new Vector<>(stack); //create vector with stack content
        vector.add(15); // adding  15 to vector
        vector.remove(1);
        System.out.println(vector); // [10, 12, 13, 14, 15]

        PriorityQueue<String> pqueue = new PriorityQueue<>(); // ordered data structure
        pqueue.add("Messi");
        pqueue.add("Ronaldo");
        pqueue.offer("Lewandowski");
        pqueue.offer("Mbappe");
        pqueue.add("Bounou");
        pqueue.offer("Perez");
        System.out.println( pqueue.poll()); // remove first element -> Bounou
        System.out.println(pqueue.peek()); // get last first element -> Lewandowski

        System.out.println(pqueue); // [Lewandowski, Mbappe, Messi, Ronaldo, Perez]
    }
}
