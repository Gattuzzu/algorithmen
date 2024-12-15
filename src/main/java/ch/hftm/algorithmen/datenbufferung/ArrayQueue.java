package ch.hftm.algorithmen.datenbufferung;

public class ArrayQueue implements InterfaceQueue{
  private Object[] queue;
  private int actIndex;

  public ArrayQueue(int size){
    queue = new Object[size];
    actIndex = 0;
  }

  public ArrayQueue(){
    this(5);
  }

  public void insert(Object item){
    if (isFull()){
      throw new ArrayIndexOutOfBoundsException("ArryQueue voll!");
    }
    queue[actIndex++] = item;
  }

  public Object remove(){
    if (isEmpty()){
      // throw new ArrayIndexOutOfBoundsException("ArryQueue lehr!");
      return null;
    }
    Object item = queue[0];
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
