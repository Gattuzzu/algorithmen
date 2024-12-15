package ch.hftm.algorithmen.datenbufferung;

public class ArrayQueueRingBufferGeneric<T> implements InterfaceQueueGeneric<T>{
  private T[] queue;
  private int readIndex;
  private int writeIndex;
  private int numberOfItems;

  public ArrayQueueRingBufferGeneric(int size){
    queue = (T[]) new Object[size];
    readIndex = 0;
    writeIndex = 0;
    numberOfItems = 0;
  }

  public void insert(T item){
    if (isFull()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue voll!");
    }
    queue[writeIndex++] = item;
    writeIndex = setIndexTo0(writeIndex);
    numberOfItems++;
  }

  public T remove(){
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      // return null;
    }
    T item = queue[readIndex];
    queue[readIndex++] = null;
    readIndex = setIndexTo0(readIndex);
    numberOfItems--;
    return item;
  }

  public boolean isEmpty(){
    return (numberOfItems == 0);
  }

  public boolean isFull(){
    return (numberOfItems == queue.length);
  }

  private int setIndexTo0(int index){
    if(index == queue.length){
      index = 0;
    }
    return index;
  }
}
