package ch.hftm.algorithmen.pruefungssimmulation;

import java.util.Stack;

class MyStack {
    private Stack<String> stack = new Stack<>();

    public void push(String value) { stack.push(value); }
    public String pop() { return stack.isEmpty() ? null : stack.pop(); }
    public boolean isEmpty() { return stack.isEmpty(); }
}
