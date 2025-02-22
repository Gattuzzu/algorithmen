package ch.hftm.algorithmen.pruefungssimmulation;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private Queue<String> queue = new LinkedList<>();

    public void enqueue(String value) { queue.add(value); }
    public String dequeue() { return queue.poll(); }
    public boolean isEmpty() { return queue.isEmpty(); }
}
