package ch.hftm.algorithmen.linkedList;

import ch.hftm.algorithmen.datenbufferung.InterfaceStackGeneric;

public class LinkedListGenericStack<T> implements InterfaceStackGeneric<T> {
  private LinkedListGeneric<T> stack;

  public LinkedListGenericStack(){
    stack = new LinkedListGeneric<>();
  }

  @Override
  public void push(T item) {
    stack.addFirst(item);
  }

  @Override
  public T pop() {
    return stack.removeFirst();
  }

  @Override
  public T peek() {
    return stack.getFirst();
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  @Override
  public boolean isFull() {
    // Die Liste kann ohne limit wachsen, deshalb gibt es keine Maximale Grösse, ausser der Speicher vom Gerät.
    return false;
  }

  @Override
  public int size() {
    return stack.size();
  }
  
}
