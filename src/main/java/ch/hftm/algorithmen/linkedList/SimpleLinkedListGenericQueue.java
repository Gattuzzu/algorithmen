package ch.hftm.algorithmen.linkedList;

import ch.hftm.algorithmen.datenbufferung.InterfaceQueueGeneric;

public class SimpleLinkedListGenericQueue<T> implements InterfaceQueueGeneric<T> {
  private SimpleLinkedListGeneric<T> queue;

  public SimpleLinkedListGenericQueue(){
    queue = new SimpleLinkedListGeneric<>();
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
  public boolean isFull() {
    // Die Liste kann ohne limit wachsen, deshalb gibt es keine Maximale Grösse, ausser der Speicher vom Gerät.
    return false;
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public int size() {
    return queue.size();
  }
  
}
