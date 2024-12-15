package ch.hftm.algorithmen.datenbufferung;

public class ArrayQueueGeneric<T> implements InterfaceQueueGeneric<T>{
  private T[] queue;
  private int actIndex;

  public ArrayQueueGeneric(int size){
    // Ein Generisches Objekt kann nicht instanziert werden.
    // Deshalb wird ein Array vom Typ Object instanziert und dann in ein Arry vom Typ T gecastet
    queue = (T[]) new Object[size];
    actIndex = 0;
  }

  public void insert(T item){
    if (isFull()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue voll!");
    }
    queue[actIndex++] = item;
  }

  public T remove(){
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      // return null;
    }
    T item = queue[0];
    System.arraycopy(queue, 1, queue, 0, queue.length - 1);
    queue[--actIndex] = null;
    return item;
  }

  public boolean isEmpty(){
    return (actIndex == 0);
  }

  public boolean isFull(){
    return (actIndex == queue.length);
  }
  
}
