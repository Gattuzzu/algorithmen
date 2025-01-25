package ch.hftm.algorithmen.datenbufferung;

public interface InterfaceStackGeneric<T> {
  public void push(T item);

  public T pop();

  public T peek();

  public boolean isEmpty();

  public boolean isFull();

  public int size();
  
}
