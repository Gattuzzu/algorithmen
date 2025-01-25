package ch.hftm.algorithmen.linkedList;

import ch.hftm.algorithmen.datenbufferung.InterfaceStackGeneric;

public class SimpleLinkedListGenericStack<T> extends SimpleLinkedListGeneric<T> implements InterfaceStackGeneric<T> {

  public SimpleLinkedListGenericStack(){
    super();
  }
  
  @Override
  public void push(T item) {
    super.addFirst(item);
  }

  @Override
  public T pop() {
    return super.removeFirst();
  }

  @Override
  public T peek() {
    return super.getFirst();
  }

  @Override
  public boolean isFull() {
    // Die Liste kann ohne limit wachsen, deshalb gibt es keine Maximale Grösse, ausser der Speicher vom Gerät.
    return false;
  }
  
}
