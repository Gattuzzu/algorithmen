package ch.hftm.algorithmen.datenbufferung;

public class ArrayQueueRingBuffer extends ArrayQueueRingBufferGeneric<Object> implements InterfaceQueue{

  public ArrayQueueRingBuffer(int size){
    super(size);
  }

  public ArrayQueueRingBuffer(){
    this(5);
  }

}
