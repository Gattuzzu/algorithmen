package ch.hftm.algorithmen.linkedList;

public interface InterfaceLinkedListGeneric<T>{
 
  public void addLast(T object);
  
  public void addFirst(T object);

  public boolean contains(T object);
  
  public boolean remove(T object);

  public T removeFirst();

  public T removeLast();

  public void clear();

  public void reverse();

  public void merge(InterfaceLinkedListGeneric<T> list2);
      
  public T getFirst();
  
  public T findNthFromEnd(int n);

  public T get(int index);

  public T getLast();

  public boolean isEmpty();

  public int size();

}
