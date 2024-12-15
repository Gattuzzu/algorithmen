package ch.hftm.algorithmen.datenbufferung;

public class ArrayQueue extends ArrayQueueGeneric<Object> implements InterfaceQueue{

    public ArrayQueue(int size){
      super(size);
    }

    public ArrayQueue(){
      this(5);
    }
  
}
