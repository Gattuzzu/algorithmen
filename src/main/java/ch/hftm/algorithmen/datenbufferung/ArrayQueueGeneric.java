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
    T item = front();
    System.arraycopy(queue, 1, queue, 0, queue.length - 1);
    queue[--actIndex] = null;
    return item;
  }

  public T front(){
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      // return null;
    }
    return queue[0];
  }

  public boolean isEmpty(){
    return (actIndex == 0);
  }

  public boolean isFull(){
    return (actIndex == queue.length);
  }

  public int size(){
    // Act Index ist immer auf dem nächst höheren Index um ein Objekt direkt hinzuzufügen. Deshalb stimmt der actIndex mit der Size überein
    return actIndex;
  }

  public String showAllEntries(){
    StringBuilder stringBuilder = new StringBuilder();
    int index = 0;

    while(actIndex > index){
      stringBuilder.append(queue[index].toString());
      stringBuilder.append("\n");
      index++;
    }

    return stringBuilder.toString();
  }
  
}
