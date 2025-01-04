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
    writeIndex = setIndexToRange(writeIndex);
    numberOfItems++;
  }

  public T remove(){
    T item = front();
    queue[readIndex++] = null;
    readIndex = setIndexToRange(readIndex);
    numberOfItems--;
    return item;
  }

  public T front(){
    if (isEmpty()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      // return null;
    }
    return queue[readIndex];
  }

  public boolean isEmpty(){
    return (numberOfItems == 0);
  }

  public boolean isFull(){
    return (numberOfItems == queue.length);
  }

  private int setIndexToRange(int index){
    return index % queue.length;
  }

  public int size(){
    return numberOfItems;
  }

  public String showAllEntries(){
    StringBuilder stringBuilder = new StringBuilder();
    int index = 0;

    while(numberOfItems > index){
      stringBuilder.append(queue[setIndexToRange(readIndex + index)].toString());
      stringBuilder.append("\n");
      index++;
    }

    return stringBuilder.toString();
  }
}
