package abcde.collects;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.offer(11);
        queue.offer(12);
        queue.add(13);
        System.out.println(queue.peek()); // read from front 10
        System.out.println(queue.poll()); // remove from front 10
        System.out.println(queue.element()); // read from front 11
        System.out.println(queue.remove()); // remove from front 11
        System.out.println(queue.peek()); // read from front 12

        System.out.println("------- DEQUEUE ------"); // read from front 12

        Deque<Integer> deque = new LinkedList<>();
        deque.add(10);
        deque.addFirst(11);
        deque.addAll(queue);
        deque.offerFirst(14);
        deque.addLast(19);
        deque.offerLast(20);
        deque.forEach(System.out::println);
        System.out.println("-Deque methods-");
        System.out.println("Get first element: "+ deque.getFirst()); //20
        System.out.println("Peek first element: " + deque.peekFirst()); //20
        System.out.println("Peek:" + deque.peek()); // first element also
        System.out.println("Peek last element: " + deque.peekLast()); // 20
        System.out.println("Get last element" + deque.getLast()); // 20
        System.out.println("Remove last element: " + deque.removeLast()); // 20
        System.out.println("Remove first element: " + deque.removeFirst()); // 14
        System.out.println("Poll element: " + deque.poll()); //11 remove first element 11
        System.out.println("Pop element: "+ deque.pop()); // remove first element 10
        System.out.println("Poll last element: "+ deque.pollLast()); // 20

        deque.forEach(System.out::println);

        System.out.println("--------DEQUE--------");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(1);
        stack.offer(2);
        stack.addAll(deque);
        stack.push(3);
        stack.peek();
        stack.pop();
        stack.forEach(System.out::println);


    }
}
