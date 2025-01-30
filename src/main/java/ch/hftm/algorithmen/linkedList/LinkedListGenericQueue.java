package ch.hftm.algorithmen.linkedList;

import ch.hftm.algorithmen.datenbufferung.InterfaceQueueGeneric;

public class LinkedListGenericQueue<T> implements InterfaceQueueGeneric<T> {
  private LinkedListGeneric<T> queue;

  public LinkedListGenericQueue(){
    queue = new LinkedListGeneric<>();
  }

  @Override
  public void insert(T item) {
    queue.addLast(item);
  }

  @Override
  public T remove() {
    return queue.removeFirst();
  }

  @Override
  public T front() {
    return queue.getFirst();
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public boolean isFull() {
    // Die Liste kann ohne limit wachsen, deshalb gibt es keine Maximale Grösse, ausser der Speicher vom Gerät.
    return false;
  }

  @Override
  public int size() {
    return queue.size();
  }
  
}
