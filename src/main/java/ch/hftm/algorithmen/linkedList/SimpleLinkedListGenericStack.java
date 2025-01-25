package ch.hftm.algorithmen.linkedList;

import ch.hftm.algorithmen.datenbufferung.InterfaceStackGeneric;

public class SimpleLinkedListGenericStack<T> extends SimpleLinkedListGeneric<T> implements InterfaceStackGeneric<T> {

  public SimpleLinkedListGenericStack(){
    super();
  }
  
  @Override
  public void push(T item) {
    super.addLast(item);
  }

  @Override
  public T pop() {
    return super.removeLast();
  }

  @Override
  public T peek() {
    return super.getLast();
  }

  @Override
  public boolean isFull() {
    // Die Liste kann ohne limit wachsen, deshalb gibt es keine Maximale Grösse, ausser der Speicher vom Gerät.
    return false;
  }

  
}
