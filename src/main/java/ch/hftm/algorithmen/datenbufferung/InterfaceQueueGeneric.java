package ch.hftm.algorithmen.datenbufferung;

public interface InterfaceQueueGeneric<T>{
  public void insert(T item);

  public T remove();

  public boolean isEmpty();

  public boolean isFull();
}
