package ch.hftm.algorithmen.datenbufferung;

public class ArrayQueueRingBuffer implements InterfaceQueue{
  private Object[] queue;
  private int readIndex;
  private int writeIndex;
  private int numberOfItems;

  public ArrayQueueRingBuffer(int size){
    queue = new Object[size];
    readIndex = 0;
    writeIndex = 0;
    numberOfItems = 0;
  }

  public ArrayQueueRingBuffer(){
    this(5);
  }

  public void insert(Object item){
    if (isFull()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue voll!");
    }
    queue[writeIndex++] = item;
    writeIndex = setIndexTo0(writeIndex);
    numberOfItems++;
  }

  public Object remove(){
    if (isEmpty()){
      // throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      return null;
    }
    Object item = queue[readIndex];
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
