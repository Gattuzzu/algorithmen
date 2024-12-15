package ch.hftm.algorithmen.datenbufferung;

public interface InterfaceQueue {
  public void insert(Object item);

  public Object remove();

  public boolean isEmpty();

  public boolean isFull();
}
