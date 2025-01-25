package ch.hftm.algorithmen.linkedList;

import ch.hftm.algorithmen.datenbufferung.InterfaceQueueGeneric;

public class SimpleLinkedListGenericQueue<T> extends SimpleLinkedListGeneric<T> implements InterfaceQueueGeneric<T> {

  public SimpleLinkedListGenericQueue(){
    super();
  }

  @Override
  public void insert(T item) {
    super.addLast(item);
  }

  @Override
  public T remove() {
    return super.removeFirst();
  }

  @Override
  public T front() {
    return super.getFirst();
  }

  @Override
  public boolean isFull() {
    // Die Liste kann ohne limit wachsen, deshalb gibt es keine Maximale Grösse, ausser der Speicher vom Gerät.
    return false;
  }
  
}
